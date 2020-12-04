package com.array.commonmodule.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yee
 */
public class Student extends User {
    private String studentId;
    private String nickname;
    private String mail;
    private String telephone;
    private String userFace;

    public Student() {
        super("STUDENT");
    }

    public Student(Long id, String name, String password, String studentId, String nickname, String mail, String telephone, String userFace) {
        super(id, name, password, "STUDENT");
        this.studentId = studentId;
        this.nickname = nickname;
        this.mail = mail;
        this.telephone = telephone;
        this.userFace = userFace;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "studentId='" + studentId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userFace='" + userFace + '\'' +
                '}';
    }
}
