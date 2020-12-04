package com.array.arrayserver.service;

import com.array.arrayserver.client.StudentClientFeign;
import com.array.arrayserver.config.MyPasswordEncoder;
import com.array.commonmodule.bean.Student;
import com.array.commonmodule.bean.User;
import com.array.commonmodule.bean.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yee
 */
@Service
public class StudentService implements UserDetailsService {
    @Autowired
    StudentClientFeign studentClientFeign;

    @Autowired
    MyPasswordEncoder myPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student = studentClientFeign.findStudentByName(s);
        if (student == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new Student();
        }
        return student;
    }

    public int reg(UserVo userVo) {
        User loadUserByUsername = studentClientFeign.findStudentByName(userVo.getName());
        if (loadUserByUsername != null) {
            return 1;
        }
        //插入用户,插入之前先对密码进行加密
        userVo.setPassword(myPasswordEncoder.encode(userVo.getPassword()));
        studentClientFeign.addStudent(userVo);
        return 0;
    }


    public int deleteStudentById(Long id) {
        return studentClientFeign.deleteStudentById(id);
    }


    public int updateStudent(Student student) {
        return studentClientFeign.updateStudent(student);
    }

    public List<Student> findAll() {
        return studentClientFeign.findAll();
    }

    public Student findStudentById(Long id) {
        return studentClientFeign.findStudentById(id);
    }
}
