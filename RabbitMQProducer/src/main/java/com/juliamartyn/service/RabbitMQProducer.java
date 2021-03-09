package com.juliamartyn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    public void sendMessage(String message){
        logger.info(String.format("Producing message -> %s", message));
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }
}
