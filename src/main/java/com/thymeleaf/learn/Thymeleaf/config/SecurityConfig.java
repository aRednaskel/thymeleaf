package com.thymeleaf.learn.Thymeleaf.config;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import com.thymeleaf.learn.Thymeleaf.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .and().formLogin()
                    .loginPage("/login/loginPage")
                    .loginProcessingUrl("/")
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/login/access-denied");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void userExamples() {
        User user1 = new User("John", "Legend", "email@email.com", getPasswordEncoder().encode("John"));
        userService.save(user1);
        User user2 = new User("Katy", "Perry", "email@email.com", getPasswordEncoder().encode("Katy"));
        userService.save(user2);
    }
}
