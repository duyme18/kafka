package com.hdd.kafka.producer;

import com.hdd.kafka.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer {

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaTemplate<String, Tutorial> tutorialKafkaTemplate;

    public void sendMessage(String value) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("kafka_topic_v1", value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("Messages successfully pushed on topic");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Messages failed to push on topic");
            }
        });
    }

    public void sendMessage(Tutorial value) {
        ListenableFuture<SendResult<String, Tutorial>> future = tutorialKafkaTemplate.send("kafka_topic_v1", value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Messages failed to push on topic");
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println("Messages successfully pushed on topic");
            }
        });
    }
}
