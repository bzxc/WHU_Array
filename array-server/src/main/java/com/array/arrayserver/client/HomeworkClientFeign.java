package com.array.arrayserver.client;

import com.array.commonmodule.bean.HomeWork;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@FeignClient(value = "COURSE-DATA-SERVICE")
@Service
public interface HomeworkClientFeign {
    @PostMapping("/Homework/addHomework")
    public int addHomework(@RequestBody HomeWork homeWork);

    @DeleteMapping("/Homework/{homeworkId}")
    public int deleteHomework(@PathVariable("homeworkId") Long homeworkId);

    @PutMapping("/Homework/updateHomework")
    public int updateHomework(@RequestBody HomeWork homeWork);

    @GetMapping("/Homework/{homeworkId}")
    public HomeWork findHomeworkById(@PathVariable("homeworkId") Long homeworkId);

    @GetMapping("/Homework/all")
    public List<HomeWork> findAllHomeWork();
}
