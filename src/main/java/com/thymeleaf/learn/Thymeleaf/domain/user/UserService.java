package com.thymeleaf.learn.Thymeleaf.domain.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User getUserByFirstAndLastname(String firstName, String lastName);

    User findByUsername(String username);

    void save (User user);

    void deleteById(long id);

    List<User> findByName(String name);

}
