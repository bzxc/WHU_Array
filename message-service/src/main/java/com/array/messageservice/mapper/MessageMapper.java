package com.array.messageservice.mapper;

import com.array.commonmodule.bean.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yee
 */
@Mapper
public interface MessageMapper {
    int addMessage(Message message, List<Long> userIds);

    int deleteMessage(Long messageId);

    Message getMessageById(Long messageId);

    List<Message> getMessageByUserId(Long userId);
}
