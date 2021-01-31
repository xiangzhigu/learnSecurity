package com.xiangzhi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangzhi.gu
 * @date 2021/1/31 0031 下午 3:05
 */
@RestController
public class FirstDemoContoller {

    @GetMapping("/")
    public String demo(){
        return "多喝热水";
    }
}
