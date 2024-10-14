package com.example.CrawlingSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RabbitMQController {

    private final RabbitMQConsumer rabbitMQConsumer;

    // 생성자 이름을 RabbitMQController로 변경
    public RabbitMQController(RabbitMQConsumer rabbitMQConsumer) {
        this.rabbitMQConsumer = rabbitMQConsumer;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("messages", rabbitMQConsumer.getMessages());
        return "index";  // index.html 파일을 반환
    }
}