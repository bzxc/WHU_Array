package com.array.arrayserver.client;

import com.array.commonmodule.bean.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@FeignClient(value = "COURSE-DATA-SERVICE")
@Service
public interface QuestionClientFeign {
    @PostMapping("/Question/addQuestion")
    public int addQuestion(Question question);

    @DeleteMapping("/Question/{questionId}")
    public int deleteQuestion(@PathVariable("questionId") Long questionId);

    @PutMapping("/Question/updateQuestion")
    public int updateQuestion(Question question);

    @GetMapping("/Question/{questionId}")
    public Question findQuestionById(@PathVariable("questionId") Long questionId);

    @GetMapping("/Question/findQuestionByName")
    public List<Question> findQuestionByName(String questionName);

    @GetMapping("/Question/all")
    public List<Question> findAllQuestion();
}
