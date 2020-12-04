package com.array.arrayserver.client;

import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@FeignClient(value = "USER-DATA-SERVICE")
@Service
public interface StudentClientFeign {

    @PostMapping("/student/addStudent")
    public int addStudent(@RequestBody UserVo userVo);


    @DeleteMapping("/student/{id}")
    public int deleteStudentById(@PathVariable("id") Long id);


    @PutMapping("/student/updateStudent")
    public int updateStudent(@RequestBody Student student);

    @GetMapping("/student/allStudent")
    public List<Student> findAll();

    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable("id") Long id);

    @PostMapping("/student/name")
    public Student findStudentByName(@RequestBody String name);
}
