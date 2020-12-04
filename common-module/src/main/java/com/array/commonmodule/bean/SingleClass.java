package com.array.commonmodule.bean;

/**
 * @author yee
 */
public class SingleClass {
    private Long id;
    private Long userId;
    private Long courseId;
    private int grade;

    public SingleClass() {
    }

    public SingleClass(Long id, Long userId, Long courseId, int grade) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.grade = grade;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
