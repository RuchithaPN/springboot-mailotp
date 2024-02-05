package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final CustomUserDetailsService userDetailsService;
//
//    @Autowired
//    public SecurityConfig(CustomUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/send-otp").permitAll() // Allow public access to these endpoints
//                .anyRequest().authenticated() // Require authentication for other endpoints
//                .and()
//            .csrf().disable() // Disable CSRF protection for simplicity
//            .httpBasic(); // Use basic authentication for simplicity
//    }
//
//    @Override
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//}




@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .authorizeRequests()
             .antMatchers("/register").permitAll()
             .antMatchers("/verify").permitAll()
             .anyRequest().authenticated()
         .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
         .and()
         .logout()
             .permitAll();
 }
}

