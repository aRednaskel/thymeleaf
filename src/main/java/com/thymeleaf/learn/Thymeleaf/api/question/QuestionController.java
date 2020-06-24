package com.thymeleaf.learn.Thymeleaf.api.question;

import com.thymeleaf.learn.Thymeleaf.domain.model.question.Question;
import com.thymeleaf.learn.Thymeleaf.domain.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(path = "/allQuestions")
    public ResponseEntity<List<Question>> findAllTopics() {
        return ResponseEntity.ok(questionService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.findById(id));
    }

    @GetMapping(path = "/{title}")
    public ResponseEntity<Question> findByTitle(@PathVariable String question) {
        return ResponseEntity.ok(questionService.findByQuestion(question));
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Question newQuestion = new Question();

        model.addAttribute("newQuestion", newQuestion);

        return "questions/newQuestionForm";
    }

    @PostMapping(path = "/newQuestion")
    public void addNewQuestion(@ModelAttribute("newQuestion") Question question) {
        questionService.save(question);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        questionService.deleteById(id);
    }
}
