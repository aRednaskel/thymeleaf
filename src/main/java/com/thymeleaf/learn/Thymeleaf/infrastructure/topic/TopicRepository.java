package com.thymeleaf.learn.Thymeleaf.infrastructure.topic;

import com.thymeleaf.learn.Thymeleaf.domain.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface TopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findByTitle(String title);
}
