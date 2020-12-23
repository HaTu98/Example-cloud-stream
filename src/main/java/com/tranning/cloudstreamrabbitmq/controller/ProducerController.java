package com.tranning.cloudstreamrabbitmq.controller;

import com.tranning.cloudstreamrabbitmq.config.ExampleChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(ExampleChannel.class)
public class ProducerController {
    private final MessageChannel example;

    public ProducerController(@Qualifier(ExampleChannel.EXAMPLE) MessageChannel example) {
        this.example = example;
    }

    @GetMapping("/example/{name}")
    public String  producer(@PathVariable String name) {
        Message<String> msg = MessageBuilder.withPayload(name)
                .build();
        this.example.send(msg);
        return "Send message success!";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
