package com.elevengroup.watch.entity;

import lombok.Data;

@Data
public class ChatMessage {
    private String from;
    private String content;
    private String phoneNumber;
    private MessageType type;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
