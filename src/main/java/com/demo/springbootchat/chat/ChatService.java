package com.demo.springbootchat.chat;

import com.demo.springbootchat.chat.data.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ObjectMapper mapper;
    private final Map<String, ChatRoom> chatRooms = new ConcurrentHashMap<>();

    public ChatRoom createChatRoom(String name) {
        String roomId = UUID.randomUUID().toString(); // 랜덤한 방 아이디 생성

        // Builder 를 이용해서 ChatRoom 을 Building
        ChatRoom room = ChatRoom.builder()
                .roomId(roomId)
                .name(name)
                .build();

        chatRooms.put(roomId, room); // 랜덤 아이디와 room 정보를 Map 에 저장
        return room;
    }

    public ChatRoom findChatRoomById(String roomId) {
        return chatRooms.get(roomId);
    }

    public <T> void sendMessage(WebSocketSession session, T message) {
        try{
            session.sendMessage(new TextMessage(mapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public List<ChatRoom> findAllRooms() {
        return new ArrayList<>(chatRooms.values());
    }
}
