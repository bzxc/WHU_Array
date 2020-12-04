package com.array.commonmodule.bean;

/**
 * @author yee
 */
public class Question {
    private Long questionId;
    private Long homeworkId;
    private Long examId;
    private String questionName;
    private String questionContent;

    public Question() {
    }

    public Question(Long questionId, Long homeworkId, Long examId, String questionName, String questionContent) {
        this.questionId = questionId;
        this.homeworkId = homeworkId;
        this.examId = examId;
        this.questionName = questionName;
        this.questionContent = questionContent;
    }


    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", homeworkId=" + homeworkId +
                ", examId=" + examId +
                ", questionName='" + questionName + '\'' +
                ", questionContent='" + questionContent + '\'' +
                '}';
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
