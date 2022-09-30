package com.example.demo.security.config;

import com.example.demo.participant.AppUserRole;
import com.example.demo.participant.services.ParticipantService;
import com.example.demo.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/api/v1/registration","/login", "/css/*", "/js/*").permitAll()
//                .antMatchers("/api/v1/participant/participants").hasRole("USER")
//                .antMatchers("/api/v1/racing/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.POST,"http://localhost:8081/api/v1/racing/bike-type/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.GET,"http://localhost:8081/api/v1/racing/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.DELETE, "/api/v1/participant/**").permitAll()
//                .antMatchers("/api/v1/registration").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/api/v1/registration","/login", "/css/*", "/js/*").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/v1/participant/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/v1/participant/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/v1/registration").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
        http
                .authorizeRequests()
                .antMatchers("/", "/registration", "api/v1/registration", "login", "/css/*", "/js/*").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/v1/participant/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/participant/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/participant/update/**").permitAll()
                .anyRequest()
                .authenticated().and().formLogin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(participantService)
                .passwordEncoder(passwordEncoder);

    }

//    @Bean
//    public AuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider =
//                new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(participantService);
//        return provider;
//    }

}