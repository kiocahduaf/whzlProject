package com.whzl.modules.company.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whzl.common.loginForm.LoginForm;
import com.whzl.common.utils.JwtUtils;
import com.whzl.common.utils.R;
import com.whzl.common.validator.ValidatorUtils;
import com.whzl.modules.company.service.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * APP登录授权
 *
 * @author xuchao
 * @email 1009470059@qq.com
 * @date 2019-01-26 10:33
 */
@RestController
@RequestMapping("/company")
@Api("PERSON登录接口")
public class CompanyLoginController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        long companyId = companyService.login(form);

        //生成token
        String token = jwtUtils.generateToken(companyId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);
    }

}
