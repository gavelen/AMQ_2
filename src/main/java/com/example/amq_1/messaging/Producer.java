package com.example.amq_1.messaging;

import com.example.amq_1.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produce")
@Slf4j
public class Producer {
    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    @PostMapping("/message")
    public Message sendMessage(@RequestBody Message message) {
        if (!StringUtils.hasText(message.getText())) {
            Message emptyMessage = new Message();
            emptyMessage.setText("The message is empty");
            log.info(emptyMessage.getText());
            return emptyMessage;
        }
        jmsTemplate.convertAndSend(queue, message.getText());
        return message;
    }



}
