package com.array.arrayserver.controller;

import com.array.arrayserver.client.CourseClientFeign;
import com.array.arrayserver.client.HomeworkClientFeign;
import com.array.arrayserver.client.MessageClientFeign;
import com.array.commonmodule.bean.HomeWork;
import com.array.commonmodule.bean.Message;
import com.array.commonmodule.bean.Student;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/homework")
public class HomeworkController {
    @Autowired
    HomeworkClientFeign homeworkClientFeign;

    @Autowired
    MessageClientFeign messageClientFeign;

    @Autowired
    CourseClientFeign courseClientFeign;

    @PostMapping("/addHomework")
    public int addHomework(@RequestBody HomeWork homeWork) throws IOException {
        Long homeworkId = homeWork.getHomeworkId();
        String courseName = courseClientFeign.findCourseById(homeWork.getCourseId()).getCourseName();
        String messageContent = "你的课程" + courseName + "有了新作业，点击查看";
        Message message = new Message(homeworkId, messageContent);
        messageClientFeign.addMessage(message, homeWork.getCourseId());
        List<Student> students = courseClientFeign.findStudentByCourseId(homeWork.getCourseId());
        for(Student student: students) {
            WebSocketServer.sendInfo("1", student.getStudentId().toString());
        }
        return homeworkClientFeign.addHomework(homeWork);
    }

    @DeleteMapping("/{homeworkId}")
    public int deleteHomework(@PathVariable("homeworkId") Long homeworkId) {
        return homeworkClientFeign.deleteHomework(homeworkId);
    }

    @PutMapping("/updateHomework")
    public int updateHomework(@RequestBody HomeWork homeWork) {
        Long homeworkId = homeWork.getHomeworkId();
        String courseName = courseClientFeign.findCourseById(homeWork.getCourseId()).getCourseName();
        String messageContent = "你的课程" + courseName + "作业有更新，点击查看";
        Message message = new Message(homeworkId, messageContent);
        messageClientFeign.addMessage(message, homeWork.getCourseId());
        return homeworkClientFeign.updateHomework(homeWork);
    }

    @GetMapping("/{homeworkId}")
    public HomeWork findHomeworkById(@PathVariable("homeworkId") Long homeworkId) {
        return homeworkClientFeign.findHomeworkById(homeworkId);
    }

    @GetMapping("/all")
    public List<HomeWork> findAllHomeWork() {
        return homeworkClientFeign.findAllHomeWork();
    }
}
