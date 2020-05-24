package com.thymeleaf.learn.Thymeleaf.infrastructure.user;

import com.thymeleaf.learn.Thymeleaf.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
