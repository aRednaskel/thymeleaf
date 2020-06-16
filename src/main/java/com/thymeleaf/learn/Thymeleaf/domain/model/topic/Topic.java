package com.thymeleaf.learn.Thymeleaf.domain.model.topic;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topics")
@RequiredArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Question> questionSet;
}
