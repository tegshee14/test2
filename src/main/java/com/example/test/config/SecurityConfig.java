package com.example.test.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig   {
 /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.csrf(AbstractHttpConfigurer::disable);
//        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("").permitAll()
//                .requestMatchers("").permitAll()
//                .anyRequest().authenticated()
//        );
        http.authorizeHttpRequests(request -> request.dispatcherTypeMatchers(DispatcherType.FORWARD)
                .permitAll().anyRequest().authenticated()
        ).formLogin(login -> login.loginPage("/")
                .loginProcessingUrl("/login-process")
                .usernameParameter("userid")
                .passwordParameter("pw")
                .defaultSuccessUrl("/")
                .permitAll()
        ).logout(withDefaults());


        return http.build();
    }
    */

}


