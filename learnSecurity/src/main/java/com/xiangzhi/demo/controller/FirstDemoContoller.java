package com.xiangzhi.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xiangzhi.gu
 * @date 2021/1/31 0031 下午 3:05
 */
@RestController
public class FirstDemoContoller {

    @Secured("ROLE_CDM")           //专门判断是否拥有role的
    @GetMapping("/demo")
    public String demo(){
        return "多喝热水";
    }

    @GetMapping("/showLogin")
    public ModelAndView showLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping("/showMain")      //
    public ModelAndView Main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping("/showFail")      //
    public ModelAndView showFail(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fail");
        return modelAndView;
    }

}
