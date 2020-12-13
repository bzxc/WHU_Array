package com.array.messageservice.Controller;

import com.array.commonmodule.bean.Message;
import com.array.messageservice.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yee
 */
@RestController
@RequestMapping("/Message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/addMessage")
    public int addMessage(@RequestBody Message message, @RequestParam Long courseId) {
        return messageService.addMessage(message, courseId);
    }

    @DeleteMapping("/deleteMessage")
    public int deleteMessage(Long messageId) {
        return messageService.deleteMessage(messageId);
    }

    @GetMapping("/{messageId}")
    public Message getMessageById(@PathVariable("messageId") Long messageId) {
        return messageService.getMessageById(messageId);
    }

    @GetMapping("/getMessageByUserId")
    public List<Message> getMessageByUserId(@RequestParam Long userId) {
        return messageService.getMessageByUserId(userId);
    }
}
