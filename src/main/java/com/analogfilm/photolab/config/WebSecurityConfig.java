package com.analogfilm.photolab.config;

import com.analogfilm.photolab.servise.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        // pass - 1234
//        auth.inMemoryAuthentication()
//                    .withUser("qwer")
//                    .password("$2a$10$hUf/kWuX29t73NNWOxNpf.IEBZbPiJd5m/YJGXOTSsaA7Rf0IGzJG")
//                    .roles("USER")
//                .and()
//                    .withUser("1234")
//                    .password("$2a$10$hUf/kWuX29t73NNWOxNpf.IEBZbPiJd5m/YJGXOTSsaA7Rf0IGzJG")
//                    .roles("ADMIN")
//                .and()
//                    .withUser("nikita")
//                    .password("$2a$10$hUf/kWuX29t73NNWOxNpf.IEBZbPiJd5m/YJGXOTSsaA7Rf0IGzJG")
//                    .roles("EMPLOYEE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/user-create").hasRole("ADMIN")
                    .antMatchers("/orders").hasRole("USER")
                    .antMatchers("/", "/registration", "/scans", "/films", "/access-denied", "/notFound", "/serverError", "/js/**", "/css/**", "/fonts/**", "/images/**", "/vendor/**", "/home/**").permitAll()

                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
