package com.array.userdataservice.service;

import com.array.commonmodule.bean.Teacher;
import com.array.userdataservice.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yee
 */
@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }



    public int deleteTeacherById(Long id) {
        return teacherMapper.deleteTeacherById(id);
    }


    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    public Teacher findTeacherById(Long id) {
        return teacherMapper.findTeacherById(id);
    }

    public Teacher findTeacherByName(String name) {
        return teacherMapper.findTeacherByName(name);
    }
}
