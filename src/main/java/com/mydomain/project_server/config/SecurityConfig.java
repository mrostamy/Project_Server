package com.mydomain.project_server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    final
    DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled from users where username =?")
                .authoritiesByUsernameQuery("select username,role from roles where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.formLogin().disable();
        http.authorizeRequests().antMatchers("/**").permitAll();
        http.requiresChannel().anyRequest().requiresSecure().redirectStrategy(new DefaultRedirectStrategy());
        http.headers().contentSecurityPolicy("form-action 'self'");
        http.headers().frameOptions().sameOrigin();
//        http.headers().httpStrictTransportSecurity().preload(true);
//        http.headers().httpStrictTransportSecurity().includeSubDomains(true);
//        http.headers().httpStrictTransportSecurity().maxAgeInSeconds(360000L);
        return http.build();
    }
}
