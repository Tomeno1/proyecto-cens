package com.proyectcens.springbootcens.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        var user   = User.withUsername("tomeno")
//                .password("tasq2801")
//                .roles("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance(); //No apto para producción
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}