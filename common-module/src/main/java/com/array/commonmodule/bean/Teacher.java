package com.array.commonmodule.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yee
 */
public class Teacher extends User {

    public Teacher() {
    }

    public Teacher(Long id, String name, String password) {
        super(id, name, password, "TEACHER");
    }
}
