package com.rongyi.service.impl;

import com.rongyi.dto.RegisterDto;
import com.rongyi.untils.AppException;
import com.rongyi.untils.AppExceptionCodeMsg;
import com.rongyi.untils.JwtTokenUtils;
import com.rongyi.untils.Md5Utils;
import com.rongyi.dto.LoginDto;
import com.rongyi.entity.User;
import com.rongyi.mapper.UserMapper;
import com.rongyi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    private static final String salt="rongyi";
    private Logger logger= LoggerFactory.getLogger(UserService.class);
    @Override
    public String doLogin(LoginDto loginDto) {
        // MD5 encryption
        String password = loginDto.getPassword();
        String encodedPassword = Md5Utils.hash(password+salt);
        logger.info("encoded password--"+encodedPassword);
        // find in database
        User user = userMapper.queryByUsernameAndPassword(loginDto.getUsername(),encodedPassword);
        if(Objects.isNull(user)){
            throw new AppException(AppExceptionCodeMsg.Username_PASSWORD_INCORRECT);
        }
        // generate token
        String token = JwtTokenUtils.generateToken(user.getUid(), user.getUsername(), user.getAvatar(),user.getNickname());
        logger.info("token--"+token);
        return token;
    }

    @Override
    public void doRegister(RegisterDto registerDto) {
        // check if username or email duplicated

        // send email to the address


    }

    @Override
    public void doVerifyEmail(String id) {
        // check if username or email duplicated again

        // add data into database

    }
}
