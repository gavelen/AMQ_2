package com.example.amq_1.conf;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
@EnableJms
public class SpringActiveMQConfig {

    @Value("${activemq.broker.url}")
    private String brokerUrl;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("queue_1");
    }
    @Bean
    public Queue queueSecond() {
        return new ActiveMQQueue("queue_2");
    }
    @Bean
    public Queue queueThird() {
        return new ActiveMQQueue("queue_3");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(activeMQConnectionFactory());
    }

}
