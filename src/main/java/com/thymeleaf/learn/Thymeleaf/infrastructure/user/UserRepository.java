package com.thymeleaf.learn.Thymeleaf.infrastructure.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByOrderByLastNameAsc();

    List<User> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lastName);

    Optional<User> findByFirstNameAndLastNameContainsAllIgnoreCase(String firstName, String lastName);

    Optional<User> findByUsername(String username);
}
