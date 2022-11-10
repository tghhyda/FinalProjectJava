package edu.tdtu.huy1.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
public class AdminSecurtyConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        return new CostumeUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


    // Phân quyền
    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
        http.antMatcher("/admin/**")
                .authorizeRequests().anyRequest()
                .hasAuthority("ADMIN")
                .and()
                    .formLogin().loginPage("/admin/login")
                    .usernameParameter("email")
                    .loginProcessingUrl("/admin/login")
                    .defaultSuccessUrl("/admin/home")
                    .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/admin/login")
                .and()
                .rememberMe()
                    .key("mdadasdkkkalaadmin015122")
                    .tokenValiditySeconds(3 * 24 * 60 * 60)
                .and()
                .logout().logoutUrl("/admin/logout")
                .logoutSuccessUrl("/");
        return http.build();
    }
}
