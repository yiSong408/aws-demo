package com.rongyi.service;


import com.rongyi.dto.LoginDto;
import com.rongyi.dto.RegisterDto;

public interface UserService {


    String doLogin(LoginDto loginDto);

    void doRegister(RegisterDto registerDto);

    void doVerifyEmail(String id);
}
