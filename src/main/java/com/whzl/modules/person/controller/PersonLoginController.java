package com.whzl.modules.person.controller;


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
import com.whzl.modules.person.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * APP登录授权
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/person")
@Api("PERSON登录接口")
public class PersonLoginController {
    @Autowired
    private PersonService personService;
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
        long personId = personService.login(form);

        //生成token
        String token = jwtUtils.generateToken(personId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);
    }

}
