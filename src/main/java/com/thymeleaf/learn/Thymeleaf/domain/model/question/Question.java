package com.thymeleaf.learn.Thymeleaf.domain.model.question;

import com.thymeleaf.learn.Thymeleaf.domain.model.topic.Topic;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "questions", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String fourthAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Question(Topic topic) {
        this.topic = topic;
    }

}
