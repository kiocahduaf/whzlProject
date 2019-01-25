package com.whzl.modules.company.controller;


import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whzl.common.loginForm.RegisterForm;
import com.whzl.common.utils.R;
import com.whzl.common.validator.ValidatorUtils;
import com.whzl.modules.company.entity.CompanyEntity;
import com.whzl.modules.company.service.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/company")
@Api("PERSON注册接口")
public class CompanyRegisterController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        CompanyEntity company = new CompanyEntity();
        company.setMobile(form.getMobile());
        company.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        company.setCreateTime(new Date());
        companyService.insert(company);

        return R.ok();
    }
}
