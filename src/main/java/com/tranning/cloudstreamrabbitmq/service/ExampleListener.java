package com.tranning.cloudstreamrabbitmq.service;

import com.tranning.cloudstreamrabbitmq.config.ExampleChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ExampleChannel.class)
public class ExampleListener {

    @StreamListener(target = ExampleChannel.EXAMPLE)
    public void process(String msg) {
        System.out.println(msg);
    }
}
