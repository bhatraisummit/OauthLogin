/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author Sumit
 */
@Configuration
public class OAuth2LoginConfig {

    @EnableWebSecurity
    public static class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/login","/static/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2Login()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("user")
                    .passwordParameter("pass")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/")
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login?logout");
        }
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("ADMIN").build());
        return manager;
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration(), this.facebookClientRegistration());
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {
        return new InMemoryOAuth2AuthorizedClientService(this.clientRegistrationRepository());
    }

    private ClientRegistration googleClientRegistration() {
        return CommonOAuth2Provider.GOOGLE.getBuilder("google")
                .clientId("453204317598-1anp7eh7uck7qasrf18kqusvnrnfv6sq.apps.googleusercontent.com")
                .clientSecret("xE7AUyv_24WaNIVZeuziVgpQ")
                .build();
    }

    private ClientRegistration facebookClientRegistration() {
        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook")
                .clientId("928328337333327")
                .clientSecret("eef292e9ae32809c4eac4b242588d3db")
                .build();
    }
}
