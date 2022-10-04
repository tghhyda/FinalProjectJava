package com.trangiahuytdtu.finalproject.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                .logout().logoutUrl("/reader/logout")
                .logoutSuccessUrl("/");
        return http.build();
    }
}
