package com.array.coursedataservice.controller;

import com.array.commonmodule.bean.Course;
import com.array.commonmodule.bean.HomeWork;
import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.User;
import com.array.commonmodule.bean.vo.CourseVO;
import com.array.coursedataservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public int addCourse(@RequestBody CourseVO courseVO) {
        Course course = new Course();
        course.setCourseId(courseVO.getCourseId());
        course.setCourseName(courseVO.getCourseName());
        course.setTeacherId(courseVO.getTeacherId());
        return courseService.addCourse(course);
    }

    @DeleteMapping("/{courseId}")
    public int deleteCourse(@PathVariable("courseId") Long courseId) {
        return courseService.deleteCourse(courseId);
    }

    @PutMapping("/updateCourse")
    public int updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @GetMapping("/{courseId}")
    public Course findCourseById(@PathVariable("courseId") Long courseId) {
        return courseService.findCourseById(courseId);
    }

    @GetMapping("/findCourseByName")
    public List<Course> findCourseByName(@RequestParam String courseName) {
        return courseService.findCourseByName(courseName);
    }

    @GetMapping("/all")
    public List<Course> findAllCourse() {
        return courseService.findAllCourse();
    }

    @GetMapping("/{courseId}/allStudent")
    public List<Student> findStudentByCourseId(@PathVariable("courseId") Long courseId) {
        return courseService.findStudentByCourseId(courseId);
    }

    @GetMapping("/{courseId}/allHomework")
    public List<HomeWork> findHomeWorkByCourseId(@PathVariable("courseId") Long courseId) {
        return courseService.findHomeWorkByCourseId(courseId);
    }
}
