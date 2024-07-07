package com.sample.kafka_demo.kafka;

import com.sample.kafka_demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "topicName_json", groupId = "myGroup")
    public void consumer(User user) {
        LOGGER.info("JSOM message received -> {}", user.toString());
    }
}
