package com.array.arrayserver.controller;

import com.array.arrayserver.client.TeacherClientFeign;
import com.array.arrayserver.service.TeacherService;
import com.array.commonmodule.bean.RespBean;
import com.array.commonmodule.bean.Teacher;
import com.array.commonmodule.bean.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherClientFeign teacherClientFeign;
    @GetMapping("/hello")
    public String hello() {
        return "hello teacher";
    }

    @RequestMapping("/login")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录!");
    }

    @PostMapping("/reg")
    public RespBean reg(@RequestBody UserVo userVo) {
        Teacher teacher = new Teacher();
        teacher.setName(userVo.getName());
        teacher.setPassword(userVo.getPassword());
        int result = teacherService.reg(teacher);
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

    @DeleteMapping("/{id}")
    public int deleteTeacherById(@PathVariable("id") Long id) {
        return teacherClientFeign.deleteTeacherById(id);
    }

    @PutMapping("/update")
    public int updateTeacher(Teacher teacher) {
        return teacherClientFeign.updateTeacher(teacher);
    }

    @GetMapping("/all")
    public List<Teacher> findAll() {
        return teacherClientFeign.findAll();
    }

    @GetMapping("/{id}")
    public Teacher findTeacherById(@PathVariable Long id) {
        return teacherClientFeign.findTeacherById(id);
    }

    @PostMapping("/name")
    public Teacher findTeacherByName(@RequestBody String name) {
        return teacherClientFeign.findTeacherByName(name);
    }
}
