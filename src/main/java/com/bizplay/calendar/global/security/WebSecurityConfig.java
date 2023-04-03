package com.bizplay.calendar.global.security;

import com.bizplay.calendar.global.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터를 스프링 필터체인에 등록
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // front side 주소
    @Value("${cors.allow.origin-pattern}")
    private String[] allowedOrigins;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().configurationSource(corsConfigurationSource());
        http
                // 세션 생성 방지 ( 해당 프로젝트의 유저 인증은 JWT 사용하는데 세션 필요한가? )
//                .sessionManagement((session)->session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests() // HttpServletRequest 이용 선언
                .antMatchers(
                        "/"
                        // 인증 없이 접근 해야되는 페이지가 있다면 여기에 선언
                ) // 특정 경로 지정
                .permitAll(); // 모든 사용자 접근 허용

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(loggingFilter, JwtAuthenticationFilter.class)
//                .addFilterBefore(exceptionHandlerFilter, LoggingFilter.class)
        ;
        return http.build();
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOriginPattern("*");
//        // 교차 출처 요청이 허용되는 출처 리스트
//        configuration.setAllowedOrigins(Arrays.asList(allowedOrigins));
//        // 허용 Method 리스트
//        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "PATCH", "DELETE"));
////        configuration.setAllowedHeaders(Arrays.asList("Authorization", "ACCESS_TOKEN", "REFRESH_TOKEN", "Cache-Control", "Content-Type"));
//        configuration.setAllowCredentials(true);
////        configuration.setExposedHeaders(Arrays.asList("*", "Set-Cookie", "ACCESS_TOKEN", "REFRESH_TOKEN"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}
