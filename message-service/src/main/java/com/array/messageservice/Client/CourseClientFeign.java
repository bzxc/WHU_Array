package com.array.messageservice.Client;

import com.array.commonmodule.bean.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author yee
 */
@FeignClient(value = "COURSE-DATA-SERVICE")
@Service
public interface CourseClientFeign {
    @GetMapping("/Course/{courseId}/allStudent")
    public List<Student> findStudentByCourseId(@PathVariable("courseId") Long courseId);
}
