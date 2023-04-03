package com.bizplay.calendar.global.security;

import com.bizplay.calendar.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("")) {
           log.info("아이디 null");
        }
        User user = User.builder()
                .username("test")
                .password("pass123")
                .build();
        return new UserDetailsImpl(user);
    }
}
