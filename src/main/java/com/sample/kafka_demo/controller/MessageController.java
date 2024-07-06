package com.sample.kafka_demo.controller;

import com.sample.kafka_demo.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // makes this class MVC
@RequestMapping("/api/v1/kafka") // define base URL for REST API
public class MessageController {

    private KafkaProducer kafkaProducer;

    // constructor-based dependency injection
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // no need to use @Autowired
    // since Spring bean only has 1 parameterised constructor

    @GetMapping("/publish")
    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    // @RequestParam(key) to get value from query parameter
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic");
    }
}
