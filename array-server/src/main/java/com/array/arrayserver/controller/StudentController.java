package com.array.arrayserver.controller;

import com.array.arrayserver.service.StudentService;
import com.array.commonmodule.bean.RespBean;
import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.User;
import com.array.commonmodule.bean.UserVo;
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

    @GetMapping("/hello")
    public String hello() {
        return "hello student";
    }

    @RequestMapping("/login")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录!");
    }

    @GetMapping("/all")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @PostMapping("/reg")
    public RespBean reg(@RequestBody UserVo userVo) {
        int result = studentService.reg(userVo);
        if (result == 0) {
            //成功
            return new RespBean("success", "注册成功!");
        } else if (result == 1) {
            return new RespBean("error", "用户名重复，注册失败!");
        } else {
            //失败
            return new RespBean("error", "注册失败!");
        }
    }


    @DeleteMapping("/{studentId}")
    public int deleteStudentById(@PathVariable("studentId") Long id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/updateStudent")
    public int updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable("studentId") Long id) {
        return studentService.findStudentById(id);
    }
}
