package com.array.arrayserver.config;

import com.array.arrayserver.exception.JwtAccessDeniedHandler;
import com.array.arrayserver.exception.JwtAuthenticationEntryPoint;
import com.array.arrayserver.filter.JWTAuthenticationFilter;
import com.array.arrayserver.filter.JWTAuthorizationFilter;
import com.array.arrayserver.service.StudentService;
import com.array.arrayserver.service.TeacherService;
import com.array.commonmodule.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class WebScurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider studentDao = new DaoAuthenticationProvider();
        studentDao.setUserDetailsService(studentService);
        studentDao.setPasswordEncoder(new MyPasswordEncoder());

        DaoAuthenticationProvider teacherDao = new DaoAuthenticationProvider();
        teacherDao.setUserDetailsService(teacherService);
        teacherDao.setPasswordEncoder(new MyPasswordEncoder());

        List<AuthenticationProvider> daos = new LinkedList<>();
        daos.add(studentDao);
        daos.add(teacherDao);

        ProviderManager manager = new ProviderManager(daos);
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and().authorizeRequests()
                .antMatchers("/auth/login").permitAll()
//                .antMatchers("/student/**").hasRole("STUDENT")
//                .antMatchers("/teacher/**").hasRole("TEACHER")
                .anyRequest().permitAll() //暂时测试用，正式使用要把上面的注释恢复，可能还要改一些其它页面权限什么的
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                .loginPage("/login")

//                .loginProcessingUrl("doLogin")
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 授权异常处理
                .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                .accessDeniedHandler(new JwtAccessDeniedHandler())
        .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html","/static/**");
    }

    @Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthenticationAccessDeniedHandler();
    }

}
