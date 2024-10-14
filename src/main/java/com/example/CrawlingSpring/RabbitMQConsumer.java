package com.example.CrawlingSpring;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class RabbitMQConsumer {

    private final List<String> messages = new ArrayList<>();

    @RabbitListener(queues = "PRE_NEWS")
    public void receiverMessage(byte[] message) {
        String receivedMessage = new String(message, StandardCharsets.UTF_8);
        messages.add(receivedMessage);  // 메시지를 리스트에 추가
        System.out.println(receivedMessage);  // 한글 메시지를 출력합니다.
    }

    public List<String> getMessages() {
        return messages;
    }
}