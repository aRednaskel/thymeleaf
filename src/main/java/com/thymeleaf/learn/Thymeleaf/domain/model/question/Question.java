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
    @Column(name = "true_first")
    private boolean trueFirst;

    private String secondAnswer;
    @Column(name = "true_second")
    private boolean trueSecond;

    private String thirdAnswer;
    @Column(name = "true_third")
    private boolean trueThird;

    private String fourthAnswer;
    @Column(name = "true_fourth")
    private boolean trueFourth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Question(Topic topic) {
        this.topic = topic;
    }

}
