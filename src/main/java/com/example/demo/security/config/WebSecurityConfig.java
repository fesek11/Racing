package com.example.demo.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // TODO: 06.07.2022 web security
        http
                .csrf().disable()
                .authorizeHttpRequests().antMatchers("api/v*/registration/**")
                .permitAll()
                .anyRequest().authenticated().and()
                .formLogin();
        return http.build();
    }
}
