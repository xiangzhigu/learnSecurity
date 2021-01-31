package com.xiangzhi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiangzhi.gu
 * @date 2021/1/31 0031 下午 3:19
 */

@SpringBootTest(classes = LearnSecurityApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

    @Test
    public void test(){
        //密码解析器
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("pwd"); //定长60位
        System.out.println(result);

        boolean match = encoder.matches("pwd",result);
        System.out.println(match);
    }
}
