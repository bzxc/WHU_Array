package com.array.arrayserver.service;

import com.array.arrayserver.client.StudentClientFeign;
import com.array.arrayserver.client.TeacherClientFeign;
import com.array.arrayserver.config.MyPasswordEncoder;
import com.array.commonmodule.bean.Teacher;
import com.array.commonmodule.bean.User;
import com.array.commonmodule.bean.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yee
 */
@Service
public class TeacherService implements UserDetailsService {
    @Autowired
    TeacherClientFeign teacherClientFeign;

    @Autowired
    MyPasswordEncoder myPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Teacher teacher = teacherClientFeign.findTeacherByName(s);
        if (teacher == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new Teacher();
        }
        return teacher;
    }

    public int reg(Teacher teacher) {
        User loadUserByUsername = teacherClientFeign.findTeacherByName(teacher.getName());
        if (loadUserByUsername != null) {
            return 1;
        }
        //插入用户,插入之前先对密码进行加密
        teacher.setPassword(myPasswordEncoder.encode(teacher.getPassword()));
        teacherClientFeign.addTeacher(teacher);
        return 0;
    }
}
