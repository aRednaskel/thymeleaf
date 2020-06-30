package com.thymeleaf.learn.Thymeleaf.domain.model.topic;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topics")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "id")
    private Set<Question> questionSet;

    public Topic(String title, String description) {
        this.title = title;
        this.description = description;
        this.questionSet = new HashSet<>();
    }

    public void addQuestion(Question question) {
        questionSet.add(question);
        question.setTopic(this);
    }
}
