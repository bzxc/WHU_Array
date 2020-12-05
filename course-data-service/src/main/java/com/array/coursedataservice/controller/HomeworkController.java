package com.array.coursedataservice.controller;

import com.array.commonmodule.bean.HomeWork;
import com.array.coursedataservice.mapper.HomeworkMapper;
import com.array.coursedataservice.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/Homework")
public class HomeworkController {
    @Autowired
    HomeworkService homeworkService;

    @PostMapping("/addHomework")
    public int addHomework(@RequestBody HomeWork homeWork) {
        return homeworkService.addHomework(homeWork);
        // sendMessage();
    }

    @DeleteMapping("/{homeworkId}")
    public int deleteHomework(@PathVariable("homeworkId") Long homeworkId) {
        return homeworkService.deleteHomework(homeworkId);
    }

    @PutMapping("/updateHomework")
    public int updateHomework(@RequestBody HomeWork homeWork) {
        return homeworkService.updateHomework(homeWork);
    }

    @GetMapping("/{homeworkId}")
    public HomeWork findHomeworkById(@PathVariable("homeworkId") Long homeworkId) {
        return homeworkService.findHomeworkById(homeworkId);
    }

    @GetMapping("/all")
    public List<HomeWork> findAllHomeWork() {
        return homeworkService.findAllHomeWork();
    }
}
