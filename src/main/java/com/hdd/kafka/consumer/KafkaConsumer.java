package com.hdd.kafka.consumer;

import com.hdd.kafka.model.Tutorial;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Tutorial value) {
        System.out.println("Message received ::" + value.toString());
    }
}
