package com.thymeleaf.learn.Thymeleaf.api.topic;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;
import com.thymeleaf.learn.Thymeleaf.domain.model.topic.Topic;
import com.thymeleaf.learn.Thymeleaf.domain.question.QuestionService;
import com.thymeleaf.learn.Thymeleaf.domain.topic.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;
    private final QuestionService questionService;


    @GetMapping(path = "/list")
    public String findAllTopics(Model model) {
        List<Topic> topics = topicService.findAll();

        model.addAttribute("topics", topics);

        return "topics/list";
    }

    @GetMapping(path = "/id")
    public Topic findById(@RequestParam("topicId") long id) {
        return topicService.findById(id);
    }

    @GetMapping(path = "/title")
    public Topic findByTitle(@RequestParam("topicName") String title) {
        return topicService.findByTitle(title);
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Topic newTopic = new Topic();

        model.addAttribute("newTopic", newTopic);

        return "topics/newTopicForm";
    }

    @PostMapping(path = "/newTopic")
    public String addNewTopic(@ModelAttribute("newTopic")  Topic topic) {
        topicService.save(topic);

        return "redirect:/topics/list";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("topicId") long id) {
        topicService.deleteById(id);

        return "redirect:/topics/list";
    }

    @GetMapping("/addQuestion")
    public String addQuestion(@RequestParam("topicId") long id, Model model) {
        Question newQuestion = new Question(topicService.findById(id));
        model.addAttribute("newQuestion", newQuestion);

        model.addAttribute("myTopic", topicService.findById(id));
        return "questions/newQuestionForm";

    }

    @PostMapping(path = "/newQuestion")
    public String addNewQuestion(@RequestParam("topicId") long id,@ModelAttribute("newQuestion") Question question) {
        questionService.save(question);
        topicService.addQuestion(questionService.findByQuestion(question.getQuestion()), id);
        return "redirect:/topics/list";
    }

    @GetMapping(path = "/questions")
    public String showAllQuestionsFromTopic(@RequestParam("topicId") long topicId, Model model) {
        Set questions = topicService.findById(topicId).getQuestionSet();
        model.addAttribute("questionSet", questions);

        return "questions/list";
    }

}
