package com.thymeleaf.learn.Thymeleaf.infrastructure.topic;

import com.thymeleaf.learn.Thymeleaf.domain.model.topic.Topic;
import com.thymeleaf.learn.Thymeleaf.domain.topic.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic findById(long id) {
        return topicRepository.findById(id)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Topic findByTitle(String title) {
        return topicRepository.findByTitle(title)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void save(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void deleteById(long id) {
        topicRepository.deleteById(id);
    }
}
