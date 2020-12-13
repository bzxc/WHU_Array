package com.array.arrayserver.controller;

import com.array.arrayserver.Utils.UserUtils;
import com.array.arrayserver.client.MessageClientFeign;
import com.array.commonmodule.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageClientFeign messageClientFeign;
    @PostMapping("/addMessage")
    public int addMessage(@RequestBody Message message, @RequestParam Long courseId) {
        return messageClientFeign.addMessage(message, courseId);
    }

    @DeleteMapping("/deleteMessage")
    public int deleteMessage(Long messageId) {
        return messageClientFeign.deleteMessage(messageId);
    }

    @GetMapping("/{messageId}")
    public Message getMessageById(@PathVariable("messageId") Long messageId) {
        return messageClientFeign.getMessageById(messageId);
    }

    @GetMapping("/getMessageByUserId")
    public List<Message> getMessageByUserId() {
        Long userId = UserUtils.getCurrentUser().getId();
        return messageClientFeign.getMessageByUserId(userId);
    }

}
