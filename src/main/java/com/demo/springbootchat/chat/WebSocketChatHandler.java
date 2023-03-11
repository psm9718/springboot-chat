package com.demo.springbootchat.chat;

import com.demo.springbootchat.chat.data.ChatRequest;
import com.demo.springbootchat.chat.data.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketChatHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : {}", payload);

        ChatRequest chatRequest = objectMapper.readValue(payload, ChatRequest.class);
        log.info("session {}", chatRequest.toString());

        ChatRoom room = chatService.findChatRoomById(chatRequest.getRoomId());
        log.info("room {}", room.toString());

        room.handleAction(session, chatRequest, chatService);
    }
}
