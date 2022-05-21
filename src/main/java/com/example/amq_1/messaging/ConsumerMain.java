package com.example.amq_1.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@RequiredArgsConstructor
@Component
@Slf4j
public class ConsumerMain {
    private final JmsTemplate jmsTemplate;
    private final Queue queueSecond;
    private final Queue queueThird;

    @JmsListener(destination = "queue_1")
    public void consumeMessage(String message) {
        jmsTemplate.convertAndSend(queueSecond, message);
        jmsTemplate.convertAndSend(queueThird, message);
        log.info("Message received from activemq Main queue --- " + message);
    }
}

