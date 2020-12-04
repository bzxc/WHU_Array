package com.array.coursedataservice.service;

import com.array.commonmodule.bean.HomeWork;
import com.array.coursedataservice.mapper.HomeworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yee
 */
@Service
public class HomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;

    public int addHomework(HomeWork homeWork) {
        return homeworkMapper.addHomework(homeWork);
        // sendMessage();
    }

    public int deleteHomework(Long homeworkId) {
        return homeworkMapper.deleteHomework(homeworkId);
    }

    public int updateHomework(HomeWork homeWork) {
        return homeworkMapper.updateHomework(homeWork);
    }

    public HomeWork findHomeworkById(Long homeworkId) {
        return homeworkMapper.findHomeworkById(homeworkId);
    }

    public List<HomeWork> findAllHomeWork() {
        return homeworkMapper.findAllHomeWork();
    }
}
