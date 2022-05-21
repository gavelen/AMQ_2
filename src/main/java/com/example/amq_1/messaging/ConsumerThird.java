package com.example.amq_1.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerThird {
    @JmsListener(destination = "queue_3")
    public void consumeMessage(String message) {
        log.info("Third queue from activemq First queue --- " + message);
    }
}
