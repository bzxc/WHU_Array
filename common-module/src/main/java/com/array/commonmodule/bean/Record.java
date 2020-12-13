package com.array.commonmodule.bean;

/**
 * @author yee
 */
public class Record {
    private Long id;
    private Long userId;
    private Long questionId;
    private Long recordGrade;
    private String lang;
    private String recordContent;

    public Record() {
    }

    public Record(Long id, Long userId, Long questionId, Long recordGrade, String lang, String recordContent) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.recordGrade = recordGrade;
        this.lang = lang;
        this.recordContent = recordContent;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", userId=" + userId +
                ", questionId=" + questionId +
                ", recordGrade=" + recordGrade +
                ", lang='" + lang + '\'' +
                ", recordContent='" + recordContent + '\'' +
                '}';
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getRecordGrade() {
        return recordGrade;
    }

    public void setRecordGrade(Long recordGrade) {
        this.recordGrade = recordGrade;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }
}
