package com.dongw00.api.webfluxmongo.controller;

import com.dongw00.api.webfluxmongo.config.KafkaProducer;
import com.dongw00.api.webfluxmongo.domain.Producers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducer producer;
    private final Producers producers;

    @GetMapping
    public String hello() {
        return "hello kafka";
    }

    @PostMapping("/producer")
    public String sendMessage(@RequestParam("message") String message) {
        System.out.println("##### producer ######");
        this.producer.sendMessage(message);
        return "success";
    }

    @GetMapping("/receiver")
    public void receiver() {
        producers.sendMessage("kafka-test", "Hello world");
    }
}
