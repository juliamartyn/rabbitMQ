package com.juliamartyn.controller;

import com.juliamartyn.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQController {

    @Autowired
    RabbitMQProducer producer;

    @RequestMapping("/send")
    public void sendMsg(@RequestParam("message") String message){
        producer.sendMessage(message);
    }
}
