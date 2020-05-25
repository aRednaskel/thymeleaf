package com.thymeleaf.learn.Thymeleaf.infrastructure.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllByOrderByLastNameAsc();
}
