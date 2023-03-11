package com.demo.springbootchat.chat;

import com.demo.springbootchat.chat.data.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatRoom creatRoom(@RequestBody String name) {
        return chatService.createChatRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRooms() {
        return chatService.findAllRooms();
    }


}
