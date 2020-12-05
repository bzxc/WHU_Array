package com.array.arrayserver.client;

import com.array.commonmodule.bean.Course;
import com.array.commonmodule.bean.HomeWork;
import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.User;
import com.array.commonmodule.bean.vo.CourseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@FeignClient(value = "COURSE-DATA-SERVICE")
@Service
public interface CourseClientFeign {
    @PostMapping("/Course/addCourse")
    public int addCourse(@RequestBody CourseVO courseVO);

    @DeleteMapping("/Course/{courseId}")
    public int deleteCourse(@PathVariable("courseId") Long courseId);

    @PutMapping("/Course/updateCourse")
    public int updateCourse(@RequestBody Course course);

    @GetMapping("/Course/{courseId}")
    public Course findCourseById(@PathVariable("courseId") Long courseId);

    @GetMapping("/Course/findCourseByName")
    public List<Course> findCourseByName(@RequestParam String courseName);

    @GetMapping("/Course/all")
    public List<Course> findAllCourse();

    @GetMapping("/Course/{courseId}/allStudent")
    public List<Student> findStudentByCourseId(@PathVariable("courseId") Long courseId);

    @GetMapping("/Course/{courseId}/allHomework")
    public List<HomeWork> findHomeWorkByCourseId(@PathVariable("courseId") Long courseId);
}
