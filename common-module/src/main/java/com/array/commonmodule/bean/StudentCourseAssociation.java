package com.array.commonmodule.bean;

/**
 * @author yee
 */
public class StudentCourseAssociation {

    private Long aid;
    private Long userId;
    private Long courseId;
    private int grade;

    public StudentCourseAssociation() {
    }

    public StudentCourseAssociation(Long aid, Long userId, Long courseId, int grade) {
        this.aid = aid;
        this.userId = userId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
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

    @Override
    public String toString() {
        return "StudentCourseAssociation{" +
                "aid=" + aid +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
