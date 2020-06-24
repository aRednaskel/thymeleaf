package com.thymeleaf.learn.Thymeleaf.domain.topic;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;
import com.thymeleaf.learn.Thymeleaf.domain.model.topic.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> findAll();

    Topic findById(long id);

    Topic findByTitle(String title);

    void save (Topic topic);

    void deleteById(long id);

    void addQuestion(Question question, long id);
}
