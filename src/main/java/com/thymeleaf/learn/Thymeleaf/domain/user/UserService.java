package com.thymeleaf.learn.Thymeleaf.domain.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    void save (User user);

    void deleteById(long id);

}
