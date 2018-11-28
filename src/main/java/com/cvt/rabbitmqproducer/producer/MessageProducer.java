package com.cvt.rabbitmqproducer.producer;


import com.cvt.rabbitmqproducer.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageProducer {
    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    MessageProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        logger.info(new Date().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.ROUTINE_KEY, message);
        logger.info("Is listener returned? "+rabbitTemplate.isReturnListener());
    }
}
