package com.array.coursedataservice.controller;

import com.array.commonmodule.bean.Record;
import com.array.coursedataservice.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/Record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @PostMapping("/addRecord")
    public int addRecord(Record record) {
        return recordService.addRecord(record);
    }

    @GetMapping("/findRecordByQuestionIdAndUserId")
    public List<Record> findRecordByQuestionIdAndUserId(Long questionId, Long userId) {
        return recordService.findRecordByQuestionIdAndUserId(questionId, userId);
    }

}
