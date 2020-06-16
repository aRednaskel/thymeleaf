package com.thymeleaf.learn.Thymeleaf.api.topic;

import com.thymeleaf.learn.Thymeleaf.domain.model.topic.Topic;
import com.thymeleaf.learn.Thymeleaf.domain.topic.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;


    @GetMapping(path = "/allTopics")
    public ResponseEntity<List<Topic>> findAllTopics() {
        return ResponseEntity.ok(topicService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Topic> findById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.findById(id));
    }

    @GetMapping(path = "/{title}")
    public ResponseEntity<Topic> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(topicService.findByTitle(title));
    }

    @PostMapping(path = "/newTopic")
    public void addNewTopic(@RequestBody Topic topic) {
        topicService.save(topic);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        topicService.deleteById(id);
    }
}
