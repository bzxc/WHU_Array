package com.array.commonmodule.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author yee
 */
public class HomeWork {
    private Long homeworkId;
    private Long courseId;
    private String homeworkContent;
    private Timestamp homeworkTime;

    public HomeWork() {
    }

    public HomeWork(Long homeworkId, Long courseId, String homeworkContent, Timestamp homeworkTime) {
        this.homeworkId = homeworkId;
        this.courseId = courseId;
        this.homeworkContent = homeworkContent;
        this.homeworkTime = homeworkTime;
    }


    @Override
    public String toString() {
        return "HomeWork{" +
                "homeworkId=" + homeworkId +
                ", courseId=" + courseId +
                ", homeworkContent='" + homeworkContent + '\'' +
                ", homeworkTime=" + homeworkTime +
                '}';
    }


    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public Timestamp getHomeworkTime() {
        return homeworkTime;
    }

    public void setHomeworkTime(Timestamp homeworkTime) {
        this.homeworkTime = homeworkTime;
    }
}
