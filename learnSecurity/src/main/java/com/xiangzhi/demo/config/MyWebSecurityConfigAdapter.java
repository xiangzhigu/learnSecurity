package com.xiangzhi.demo.config;

import com.xiangzhi.demo.exception.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiangzhi.gu
 * @date 2021/1/31 0031 下午 4:04
 */
@Configuration
public class MyWebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin(); //所有与表单有关系的
//        http.csrf(); //
//        http.authorizeRequests();//与授权相关

        http.formLogin()
                //需要提交哪个url请求是转发给自定义的登录逻辑
                .loginProcessingUrl("/login")  //表单提交请求
                .loginPage("/showLogin") //未认证时登录页面的url地址
                //认证成功后转发的地址 post请求
//                .successForwardUrl("/showMain")
                //认证成功后的处理
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.sendRedirect("/showMain");
                    }
                })
                //认证失败转发的地址
//                .failureForwardUrl("/showFail")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.sendRedirect("/showFail");
                    }
                })
                .usernameParameter("myUsername")
                .passwordParameter("myPassword");

        http.authorizeRequests()
                .antMatchers("/showLogin","/showFail").permitAll()
//                .antMatchers("/authority").hasAuthority("privilege1")
                .antMatchers("/authority").hasAnyAuthority("privilege1","abc")
                .antMatchers("/role").hasRole("CDM")
                .antMatchers("/ip").hasIpAddress("192.168.31.207")         //外界无法访问
                .antMatchers("/abc").denyAll()//放行
                .anyRequest().authenticated();

        http.exceptionHandling()
//                .accessDeniedPage("同步请求方式返回页面的请求url")
                .accessDeniedHandler(myAccessDeniedHandler);

        http.csrf().disable();
    }
}
