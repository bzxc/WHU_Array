package com.array.coursedataservice.service;

import com.array.commonmodule.bean.Record;
import com.array.coursedataservice.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yee
 */
@Service
public class RecordService {
    @Autowired
    RecordMapper recordMapper;

    public int addRecord(Record record) {
        return recordMapper.addRecord(record);
    }

    public List<Record> findRecordByQuestionIdAndUserId(Long questionId, Long userId) {
        return recordMapper.findRecordByQuestionIdAndUserId(questionId, userId);
    }
}
