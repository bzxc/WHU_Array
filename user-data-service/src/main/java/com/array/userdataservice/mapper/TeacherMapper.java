package com.array.userdataservice.mapper;

import com.array.commonmodule.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author yee
 */
@Mapper
public interface TeacherMapper {
    int addTeacher(Teacher teacher);

    int deleteTeacherById(Long id);

    int updateTeacher(Teacher teacher);

    List<Teacher> findAll();

    Teacher findTeacherById(Long id);

    Teacher findTeacherByName(String name);
}
