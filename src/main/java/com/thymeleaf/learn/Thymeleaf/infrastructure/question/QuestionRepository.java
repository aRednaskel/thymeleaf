package com.thymeleaf.learn.Thymeleaf.infrastructure.question;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> findByQuestion(String question);
}
