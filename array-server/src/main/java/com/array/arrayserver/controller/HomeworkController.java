package com.array.arrayserver.controller;

import com.array.arrayserver.client.HomeworkClientFeign;
import com.array.commonmodule.bean.HomeWork;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/homework")
public class HomeworkController {
    @Autowired
    HomeworkClientFeign homeworkClientFeign;

    @PostMapping("/addHomework")
    public int addHomework(@RequestBody HomeWork homeWork) {
        return homeworkClientFeign.addHomework(homeWork);
        // sendMessage();
    }

    @DeleteMapping("/{homeworkId}")
    public int deleteHomework(@PathVariable("homeworkId") Long homeworkId) {
        return homeworkClientFeign.deleteHomework(homeworkId);
    }

    @PutMapping("/updateHomework")
    public int updateHomework(@RequestBody HomeWork homeWork) {
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
