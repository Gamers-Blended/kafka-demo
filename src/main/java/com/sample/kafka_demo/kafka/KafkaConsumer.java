package com.sample.kafka_demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "topicName", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info("Message received -> {}", message);
    }
}
