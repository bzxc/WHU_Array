package com.array.arrayserver.client;

import com.array.commonmodule.bean.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@FeignClient(value = "USER-DATA-SERVICE")
@Service
public interface TeacherClientFeign {
    @PostMapping("/teacher/add")
    public int addTeacher(@RequestBody Teacher teacher);

    @DeleteMapping("/teacher/{id}")
    public int deleteTeacherById(@PathVariable("id") Long id);

    @PutMapping("/teacher/update")
    public int updateTeacher(Teacher teacher);

    @GetMapping("/teacher/all")
    public List<Teacher> findAll();

    @GetMapping("/teacher/{id}")
    public Teacher findTeacherById(@PathVariable Long id);

    @PostMapping("/teacher/name")
    public Teacher findTeacherByName(@RequestBody String name);
}
