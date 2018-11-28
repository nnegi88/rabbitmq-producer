package com.cvt.rabbitmqproducer.controller;

import com.cvt.rabbitmqproducer.producer.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final MessageProducer messageProducer;
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    ProducerController(MessageProducer messageProducer){
        this.messageProducer = messageProducer;
    }

    @GetMapping
    public String produce(@RequestParam String message){
        messageProducer.sendMessage(message);
        return "message sent to RabbitMQ and message = "+message;
    }
}
