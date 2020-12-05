package com.array.userdataservice.service;

import com.array.commonmodule.bean.Student;
import com.array.userdataservice.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yee
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    /**
     * 注册
     * @param student
     * @return
     */
    /*
    public int reg(Student student) {
        Student loadUserByUserId = studentMapper.findUserById(student.getUserId());
        if (loadUserByUserId != null) {
            return 1;
        }
        //插入用户,插入之前先对密码进行加密
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentMapper.addUser(student);
        return 0;
    }
     */

    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }



    public int deleteStudentById(Long id) {
        return studentMapper.deleteStudentById(id);
    }


    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    public Student findStudentById(Long id) {
        return studentMapper.findStudentById(id);
    }

    public Student findStudentByName(String name) {
        return studentMapper.findStudentByName(name);
    }

}
