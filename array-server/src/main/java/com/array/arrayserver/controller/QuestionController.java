package com.array.arrayserver.controller;

import com.array.arrayserver.client.QuestionClientFeign;
import com.array.commonmodule.bean.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionClientFeign questionClientFeign;

    @PostMapping("/addQuestion")
    public int addQuestion(Question question) {
        return questionClientFeign.addQuestion(question);
    }

    @DeleteMapping("/{questionId}")
    public int deleteQuestion(@PathVariable("questionId") Long questionId) {
        return questionClientFeign.deleteQuestion(questionId);
    }

    @PutMapping("/updateQuestion")
    public int updateQuestion(Question question) {
        return questionClientFeign.updateQuestion(question);
    }

    @GetMapping("/{questionId}")
    public Question findQuestionById(@PathVariable("questionId") Long questionId) {
        return questionClientFeign.findQuestionById(questionId);
    }

    @GetMapping("/findQuestionByName")
    public List<Question> findQuestionByName(String questionName) {
        return questionClientFeign.findQuestionByName(questionName);
    }

    @GetMapping("/all")
    public List<Question> findAllQuestion() {
        return questionClientFeign.findAllQuestion();
    }
}
