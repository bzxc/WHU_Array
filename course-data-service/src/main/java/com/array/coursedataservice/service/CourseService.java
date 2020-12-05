package com.array.coursedataservice.service;

import com.array.commonmodule.bean.Course;
import com.array.commonmodule.bean.HomeWork;
import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.User;
import com.array.coursedataservice.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yee
 */
@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    public int deleteCourse(Long courseId) {
        return courseMapper.deleteCourse(courseId);
    }

    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    public Course findCourseById(Long courseId) {
        return courseMapper.findCourseById(courseId);
    }

    public List<Course> findCourseByName(String courseName) {
        return courseMapper.findCourseByName(courseName);
    }

    public List<Course> findAllCourse() {
        return courseMapper.findAllCourse();
    }

    public List<Student> findStudentByCourseId(Long courseId) {
        return courseMapper.findStudentByCourseId(courseId);
    }

    public List<HomeWork> findHomeWorkByCourseId(Long courseId) {
        return courseMapper.findHomeWorkByCourseId(courseId);
    }
}
