package com.xiangzhi.demo.service.impl;

import com.xiangzhi.demo.service.MyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author xiangzhi.gu
 * @date 2021/1/31 0031 下午 7:25
 */
@Service
public class MyServiceImpl implements MyService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object o =  authentication.getPrincipal();
        if (o instanceof UserDetails){
            UserDetails userDetails = (UserDetails) o;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            return authorities.contains(new SimpleGrantedAuthority("ROLE_CDM"));

        }
        return false;
    }
}
