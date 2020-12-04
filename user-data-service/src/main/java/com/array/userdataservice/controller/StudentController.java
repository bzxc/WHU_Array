package com.array.userdataservice.controller;

import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.UserVo;
import com.array.userdataservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public int addStudent(@RequestBody UserVo userVo) {
        Student student = new Student();
        student.setName(userVo.getName());
        student.setPassword(userVo.getPassword());
        return studentService.addStudent(student);
    }


    @DeleteMapping("/{id}")
    public int deleteStudentById(@PathVariable("id") Long id) {
        return studentService.deleteStudentById(id);
    }


    @PutMapping("/updateStudent")
    public int updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/allStudent")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") Long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/name")
    public Student findStudentByName(@RequestBody String name) { return studentService.findStudentByName(name); }
}
