package com.thymeleaf.learn.Thymeleaf.config;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.MyUserDetails;
import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import com.thymeleaf.learn.Thymeleaf.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        return new MyUserDetails(user);
    }
}
