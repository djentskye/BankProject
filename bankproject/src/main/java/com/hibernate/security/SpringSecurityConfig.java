//package com.hibernate.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.visola.spring.security.tokenfilter.TokenAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.participantService).passwordEncoder(this.passwordEncoder());
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        final TokenAuthenticationFilter tokenFilter = new TokenAuthenticationFilter
//    }
//}
