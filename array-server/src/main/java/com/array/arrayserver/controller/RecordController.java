package com.array.arrayserver.controller;

import com.array.arrayserver.Utils.UserUtils;
import com.array.arrayserver.client.RecordClientFeign;
import com.array.commonmodule.bean.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordClientFeign recordClientFeign;

    @PostMapping("/addRecord")
    public int addRecord(Record record) {
        return recordClientFeign.addRecord(record);
    }

    @GetMapping("/{questionId}")
    public List<Record> findRecordByQuestionIdAndUserId(@PathVariable("questionId") Long questionId) {
        Long userId = UserUtils.getCurrentUser().getId();
        return recordClientFeign.findRecordByQuestionIdAndUserId(questionId, userId);
    }


}
