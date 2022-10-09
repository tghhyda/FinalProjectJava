package com.trangiahuytdtu.finalproject.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Order(2)
public class ReaderSecurityConfig {
    // Phân quyền
    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        http.antMatcher("/reader/**")
                .authorizeRequests().anyRequest()
                .hasAuthority("READER")
                .and()
                .formLogin().loginPage("/reader/login")
                    .usernameParameter("email")
                    .loginProcessingUrl("/reader/login")
                    .defaultSuccessUrl("/reader/home")
                    .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/reader/login")
                .and()
                .rememberMe()
                    .key("mdadasdkkkalal015122")
                    .tokenValiditySeconds(3 * 24 * 60 * 60)
                .and()
                .logout().logoutUrl("/reader/logout")
                .logoutSuccessUrl("/");
        return http.build();
    }
}
