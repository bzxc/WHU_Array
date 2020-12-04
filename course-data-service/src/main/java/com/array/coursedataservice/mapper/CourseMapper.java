package com.array.coursedataservice.mapper;

import com.array.commonmodule.bean.Course;
import com.array.commonmodule.bean.HomeWork;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yee
 */
@Mapper
public interface CourseMapper {
    int addCourse(Course course);

    int deleteCourse(Long courseId);

    int updateCourse(Course course);

    Course findCourseById(Long courseId);

    List<Course> findCourseByName(String courseName);

    List<Course> findAllCourse();

    List<Course> findUserByCourseId(Long courseId);

    List<HomeWork> findHomeWorkByCourseId(Long courseId);
}
