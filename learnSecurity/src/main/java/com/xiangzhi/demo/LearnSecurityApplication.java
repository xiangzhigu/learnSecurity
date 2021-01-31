package com.xiangzhi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class LearnSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSecurityApplication.class, args);
    }

}
