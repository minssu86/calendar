package com.bizplay.calendar.global.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
    public String getTokenFromHeader(HttpServletRequest request) {
        return "";
    }

    public Authentication getAuthenticationFromToken(String jwtToken) {
        return null;
    }
}
