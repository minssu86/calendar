package com.bizplay.calendar.global.security;

import com.bizplay.calendar.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    // 권한 리스트 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료되지 않았는지 리턴 ( true 이면 만료되지 않음을 의미 )
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있지 않은지를 리턴 ( true 이면 잠겨 있지 않음을 의미 )
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정의 패스워드가 만료되지 않았는지 리턴 ( true 이면 패스워드 만료 전 의미 )
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 사용 가능을 의미 ( true 이면 사용 가능한계정 )
    @Override
    public boolean isEnabled() {
        return true;
    }
}
