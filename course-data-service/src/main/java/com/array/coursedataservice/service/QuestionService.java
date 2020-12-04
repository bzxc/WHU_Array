package com.array.coursedataservice.service;

import com.array.commonmodule.bean.Question;
import com.array.coursedataservice.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yee
 */
@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper;

    public int addQuestion(Question question) {
        return questionMapper.addQuestion(question);
    }

    public int deleteQuestion(Long questionId) {
        return questionMapper.deleteQuestion(questionId);
    }

    public int updateQuestion(Question question) {
        return questionMapper.updateQuestion(question);
    }

    public Question findQuestionById(Long questionId) {
        return questionMapper.findQuestionById(questionId);
    }

    public List<Question> findQuestionByName(String questionName) {
        return questionMapper.findQuestionByName(questionName);
    }

    public List<Question> findAllQuestion() {
        return questionMapper.findAllQuestion();
    }
}
