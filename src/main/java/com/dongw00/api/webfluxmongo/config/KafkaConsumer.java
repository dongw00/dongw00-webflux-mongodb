package com.dongw00.api.webfluxmongo.config;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "sample", groupId = "myGroup")
    public void consume(String message) throws IOException {
        System.out.println("Consumer Message is " + message);
    }
}
