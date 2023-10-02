package com.rongyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@MapperScan("com.rongyi.mapper")
@SpringBootApplication
public class AwsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsDemoApplication.class, args);
    }

}
