package com.array.arrayserver.controller;

import com.array.arrayserver.client.CourseClientFeign;
import com.array.commonmodule.bean.Course;
import com.array.commonmodule.bean.HomeWork;
import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.User;
import com.array.commonmodule.bean.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseClientFeign courseClientFeign;

    @PostMapping("/addCourse")
    public int addCourse(@RequestBody CourseVO courseVO) {
        return courseClientFeign.addCourse(courseVO);
    }

    @DeleteMapping("/{courseId}")
    public int deleteCourse(@PathVariable("courseId") Long courseId) {
        return courseClientFeign.deleteCourse(courseId);
    }

    @PutMapping("/updateCourse")
    public int updateCourse(@RequestBody Course course) {
        return courseClientFeign.updateCourse(course);
    }

    @GetMapping("/{courseId}")
    public Course findCourseById(@PathVariable("courseId") Long courseId) {
        return courseClientFeign.findCourseById(courseId);
    }

    @GetMapping("/findCourseByName")
    public List<Course> findCourseByName(@RequestParam String courseName) {
        return courseClientFeign.findCourseByName(courseName);
    }

    @GetMapping("/all")
    public List<Course> findAllCourse() {
        return courseClientFeign.findAllCourse();
    }

    @GetMapping("/{courseId}/allStudent")
    public List<Student> findStudentByCourseId(@PathVariable("courseId") Long courseId) {
        return courseClientFeign.findStudentByCourseId(courseId);
    }

    @GetMapping("/{courseId}/allHomework")
    public List<HomeWork> findHomeWorkByCourseId(@PathVariable("courseId") Long courseId) {
        return courseClientFeign.findHomeWorkByCourseId(courseId);
    }
}
