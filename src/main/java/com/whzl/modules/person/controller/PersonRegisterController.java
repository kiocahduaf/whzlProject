package com.whzl.modules.person.controller;


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
import com.whzl.modules.person.entity.PersonEntity;
import com.whzl.modules.person.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/person")
@Api("PERSON注册接口")
public class PersonRegisterController {
    @Autowired
    private PersonService personService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        PersonEntity person = new PersonEntity();
        person.setMobile(form.getMobile());
        person.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        person.setCreateTime(new Date());
        personService.insert(person);

        return R.ok();
    }
}
