package com.thymeleaf.learn.Thymeleaf.domain.question;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Question findById(long id);

    Question findByQuestion(String question);

    void save (Question question);

    void deleteById(long id);
}
