package com.array.commonmodule.bean;


/**
 * @author yee
 */
public class Message {
    Long messageId;
    String messageContent;

    public Message() {
    }

    public Message(Long messageId, String messageContent) {
        this.messageId = messageId;
        this.messageContent = messageContent;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}
