package com.tranning.cloudstreamrabbitmq.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ExampleChannel {
    String EXAMPLE = "example";

    @Output(EXAMPLE)
    MessageChannel exampleInput();

    @Input(EXAMPLE)
    SubscribableChannel exampleOutput();
}
