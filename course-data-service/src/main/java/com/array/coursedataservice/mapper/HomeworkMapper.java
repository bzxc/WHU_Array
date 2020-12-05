package com.array.coursedataservice.mapper;

import com.array.commonmodule.bean.HomeWork;
import com.array.commonmodule.bean.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yee
 */
@Mapper
public interface HomeworkMapper {
    int addHomework(HomeWork homeWork);

    int deleteHomework(Long homeworkId);

    int updateHomework(HomeWork homeWork);

    HomeWork findHomeworkById(Long homeworkId);

    List<HomeWork> findAllHomeWork();

    List<Question> findQuestionByHomeworkId(Long homeworkId);

}
