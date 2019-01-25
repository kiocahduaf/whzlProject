package com.whzl.modules.person.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whzl.common.annotation.Login;
import com.whzl.common.annotation.LoginUser;
import com.whzl.common.utils.R;
import com.whzl.modules.person.entity.PersonEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * APP测试接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/person")
@Api("PERSON测试接口")
public class PersonTestController {

    @Login
    @GetMapping("personInfo")
    @ApiOperation("获取用户信息")
    public R personInfo(@LoginUser PersonEntity person){
        return R.ok().put("person", person);
    }

    @Login
    @GetMapping("personId")
    @ApiOperation("获取用户ID")
    public R personInfo(@RequestAttribute("personId") Integer personId){
        return R.ok().put("personId", personId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

}
