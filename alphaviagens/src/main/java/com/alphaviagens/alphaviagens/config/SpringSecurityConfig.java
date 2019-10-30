package com.alphaviagens.alphaviagens.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .authorizeRequests().antMatchers("/","/tours","/hotels","/hotel-room","/blog","/about","/tour-place","/services","/reclamacao").permitAll()
        .antMatchers("/contact/**").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout().logoutUrl("/logout").permitAll();

httpSecurity.csrf().disable();
httpSecurity.headers().frameOptions().disable();
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
auth
        .inMemoryAuthentication()
        .withUser("admin").password("{noop}admin").roles("ADMIN");
}
@Override
public void configure(WebSecurity web) throws Exception {
    web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/assets/**","/fonts/**","/vendor/**","/sass/**");
}
}