package com.array.commonmodule.bean;

import java.util.List;

/**
 * @author yee
 */
public class Course {
    private Long courseId;
    private Long examId;
    private Long teacherId;
    private String courseName;

    public Course() {
    }

    public Course(Long courseId, Long examId, Long teacherId, String courseName) {
        this.courseId = courseId;
        this.examId = examId;
        this.teacherId = teacherId;
        this.courseName = courseName;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", examId=" + examId +
                ", teacherId=" + teacherId +
                ", courseName='" + courseName + '\'' +
                '}';
    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
