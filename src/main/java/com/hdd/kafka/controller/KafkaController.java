package com.hdd.kafka.controller;

import com.hdd.kafka.model.Tutorial;
import com.hdd.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {
    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping(value = "/send/{message}")
    public void send(@PathVariable String message) {
        kafkaProducer.sendMessage(message);
    }

    @PostMapping(value = "/send")
    public void send(@RequestBody Tutorial tutorial) {
        kafkaProducer.sendMessage(tutorial);
    }
}
