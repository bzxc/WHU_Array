package com.array.messageservice.Service;

import com.array.commonmodule.bean.Message;
import com.array.commonmodule.bean.Student;
import com.array.messageservice.Client.CourseClientFeign;
import com.array.messageservice.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    CourseClientFeign courseClientFeign;

    public int addMessage(Message message, Long courseId) {
        List<Long> ids = new LinkedList<>();
        List<Student> students = courseClientFeign.findStudentByCourseId(courseId);
        for(Student s: students) {
            ids.add(s.getId());
        }
        return messageMapper.addMessage(message, ids);
    }

    public int deleteMessage(Long messageId) {
        return messageMapper.deleteMessage(messageId);
    }

    public Message getMessageById(Long messageId) {
        return messageMapper.getMessageById(messageId);
    }

    public List<Message> getMessageByUserId(Long userId) {
        return messageMapper.getMessageByUserId(userId);
    }
}
