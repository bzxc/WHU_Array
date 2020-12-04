package com.array.commonmodule.bean.vo;

/**
 * @author yee
 */
public class CourseVO {
    private Long courseId;
    private Long teacherId;
    private String courseName;

    public CourseVO() {
    }

    public CourseVO(Long courseId, Long teacherId, String courseName) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    @Override
    public String toString() {
        return "CourseVO{" +
                "courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
