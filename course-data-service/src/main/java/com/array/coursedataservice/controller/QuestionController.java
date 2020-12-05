package com.array.coursedataservice.controller;

import com.array.commonmodule.bean.Question;
import com.array.coursedataservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/Question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/addQuestion")
    public int addQuestion(Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/{questionId}")
    public int deleteQuestion(@PathVariable("questionId") Long questionId) {
        return questionService.deleteQuestion(questionId);
    }

    @PutMapping("/updateQuestion")
    public int updateQuestion(Question question) {
        return questionService.updateQuestion(question);
    }

    @GetMapping("/{questionId}")
    public Question findQuestionById(@PathVariable("questionId") Long questionId) {
        return questionService.findQuestionById(questionId);
    }

    @GetMapping("/findQuestionByName")
    public List<Question> findQuestionByName(String questionName) {
        return questionService.findQuestionByName(questionName);
    }

    @GetMapping("/all")
    public List<Question> findAllQuestion() {
        return questionService.findAllQuestion();
    }
}
