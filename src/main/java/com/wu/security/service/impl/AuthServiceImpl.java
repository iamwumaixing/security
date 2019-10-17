package com.wu.security.service.impl;

import com.wu.security.repository.UserRepository;
import com.wu.security.comm.constant.BizErrorCode;
import com.wu.security.comm.util.R;
import com.wu.security.entity.User;
import com.wu.security.service.AuthService;
import com.wu.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Qwu
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public R register(User userToAdd) {
        final String username = userToAdd.getUsername();
        if (userRepository.findByUsername(username) != null) {
            // 已存在此用户名
            return new R<>(BizErrorCode.USER_REPEAT);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        // 密码加密
        userToAdd.setPassword(encoder.encode(rawPassword));
        userRepository.save(userToAdd);
        return new R<>("注册成功");
    }

    @Override
    public String login(String username, String password) {
        // 1、用户名和密码获得之后组合成 UsernamePasswordAuthenticationToken的实例
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // 2、将该令牌传递给AuthenticationManager实例进行验证,验证成功后,AuthenticationManager会返回填充好的Authentication实例
        final Authentication authentication = authenticationManager.authenticate(upToken);
        // 3、通过调用SecurityContextHolder.getContext().setAuthentication(...)建立安全上下文的实例,传递到返回的身份认证对象上
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }
}
