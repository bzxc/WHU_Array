package com.array.userdataservice.controller;

import com.array.commonmodule.bean.Teacher;
import com.array.userdataservice.service.TeacherService;
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

    @PostMapping("/add")
    public int addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public int deleteTeacherById(@PathVariable("id") Long id) {
        return teacherService.deleteTeacherById(id);
    }

    @PutMapping("/update")
    public int updateTeacher(Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }

    @GetMapping("/all")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Teacher findTeacherById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @PostMapping("/name")
    public Teacher findTeacherByName(@RequestBody String name) {
        return teacherService.findTeacherByName(name);
    }
}
