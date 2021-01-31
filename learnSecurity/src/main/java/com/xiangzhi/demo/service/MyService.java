package com.xiangzhi.demo.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiangzhi.gu
 * @date 2021/1/31 0031 下午 7:24
 */


//自定义授权逻辑
public interface MyService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
