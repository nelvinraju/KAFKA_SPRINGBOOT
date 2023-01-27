package com.nelvin.kafka.service;

import com.nelvin.kafka.dto.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class KafKaProducerService {
    private static final Logger logger =
            LoggerFactory.getLogger(KafKaProducerService.class);

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendMessage(Message message)
    {
        logger.info(String.format("Message sent -> %s", message.getMessage()));
        this.kafkaTemplate.send("sample-topic4", message);
    }
}
