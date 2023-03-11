package com.demo.springbootchat.chat.data;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatRequest {

    private final MessageType type; // 메시지 타입
    private final String roomId; // 방 번호
    private final String sender; // 채팅을 보낸 사람
    private final String time; // 채팅 발송 시간
    private String message; // 메시지

    @Builder
    public ChatRequest(MessageType type, String roomId, String sender, String message, String time) {
        this.type = type;
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
        this.time = time;
    }

    public enum MessageType{
        ENTER, TALK
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
