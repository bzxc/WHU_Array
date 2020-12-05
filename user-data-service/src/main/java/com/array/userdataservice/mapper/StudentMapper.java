package com.array.userdataservice.mapper;

import com.array.commonmodule.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yee
 */
@Mapper
public interface StudentMapper {

    int addStudent(Student student);

    int deleteStudentById(Long id);

    int updateStudent(Student student);

    List<Student> findAll();

    Student findStudentById(Long id);

    Student findStudentByName(String name);
}
