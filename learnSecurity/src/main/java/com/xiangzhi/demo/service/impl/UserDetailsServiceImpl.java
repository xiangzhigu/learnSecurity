package com.xiangzhi.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author xiangzhi.gu
 * @date 2021/1/31 0031 下午 3:10
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(!username.equals("D8XIANGZ")){
            throw new UsernameNotFoundException("用户不存在");
        }

        //从数据库中获取密码
        String password = "789@Test";
        String encodePwd = encoder.encode(password);
        UserDetails userDetails = new User(username,encodePwd, AuthorityUtils.commaSeparatedStringToAuthorityList("privilege1,privilege2"));
        return userDetails;
    }
}
