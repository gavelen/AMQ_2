package com.example.amq_1.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerSecond {

    @JmsListener(destination = "queue_2")
    public void consumeMessage(String message) {
        log.info("Second queue received from activemq First queue --- " + message);
    }
}
