package com.rongyi.controller;

import com.rongyi.dto.RegisterDto;
import com.rongyi.dto.ResetPwdDto;
import com.rongyi.untils.ResultAjax;
import com.rongyi.dto.LoginDto;
import com.rongyi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/verify/{id}")
    public ResultAjax verifyEmail(@PathVariable String id){
        logger.info(id);
        userService.doVerifyEmail(id);
        return ResultAjax.success();
    }

    @RequestMapping("/register")
    public ResultAjax register(@RequestBody RegisterDto registerDto){
        logger.info(registerDto.toString());
        userService.doRegister(registerDto);
        return ResultAjax.success();
    }

    @RequestMapping("/login")
    public ResultAjax<String> login(@RequestBody LoginDto loginDto){
        logger.info(loginDto.toString());
        String token = userService.doLogin(loginDto);
        return ResultAjax.success(token);
    }

    @RequestMapping("/resetPwd")
    public ResultAjax resetPassword(@RequestBody ResetPwdDto resetPwdDto){
        logger.info(resetPwdDto.toString());

        return ResultAjax.success();
    }
}
