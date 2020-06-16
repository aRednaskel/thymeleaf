package com.thymeleaf.learn.Thymeleaf.domain.model.question;

import com.thymeleaf.learn.Thymeleaf.domain.model.topic.Topic;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@RequiredArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String[] answers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

    public Question(String question, String[] answers, Topic topic) {
        this.question = question;
        this.answers = answers;
        this.topic = topic;
    }
}
