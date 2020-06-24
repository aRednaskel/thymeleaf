package com.thymeleaf.learn.Thymeleaf.infrastructure.question;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;
import com.thymeleaf.learn.Thymeleaf.domain.question.QuestionService;
import com.thymeleaf.learn.Thymeleaf.domain.topic.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicService topicService;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(long id) {
        return questionRepository.findById(id)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));    }

    @Override
    public Question findByQuestion(String question) {
        return questionRepository.findByQuestion(question)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteById(long id) {
        questionRepository.deleteById(id);
    }
}
