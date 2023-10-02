package com.rongyi;

import com.rongyi.entity.User;
import com.rongyi.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AwsDemoApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {


    }

}
