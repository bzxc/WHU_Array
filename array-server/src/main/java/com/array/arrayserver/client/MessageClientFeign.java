package com.array.arrayserver.client;

import com.array.commonmodule.bean.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "MESSAGE-SERVICE")
@Service
public interface MessageClientFeign {
    @PostMapping("/Message/addMessage")
    public int addMessage(@RequestBody Message message, @RequestParam Long courseId);

    @DeleteMapping("/Message/deleteMessage")
    public int deleteMessage(Long messageId);

    @GetMapping("/Message/{messageId}")
    public Message getMessageById(@PathVariable("messageId") Long messageId);

    @GetMapping("/Message/getMessageByUserId")
    public List<Message> getMessageByUserId(@RequestParam Long userId);
}
