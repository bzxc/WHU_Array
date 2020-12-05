package com.array.coursedataservice.mapper;

import com.array.commonmodule.bean.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yee
 */
@Mapper
public interface RecordMapper {
    int addRecord(Record record);

    List<Record> findRecordByQuestionIdAndUserId(Long questionId, Long userId);
}
