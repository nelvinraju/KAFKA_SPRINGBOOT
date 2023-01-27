package com.nelvin.kafka.service;

import com.nelvin.kafka.dto.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class KafKaConsumerService {
    private final Logger logger =
             LoggerFactory.getLogger(KafKaConsumerService.class);

    @KafkaListener(id = "sampleGroup", topics = "sample-topic4", containerFactory = "jsonKafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, Message> cr, @Payload Message payload)
    {
        logger.error(String.format("Message recieved -> %s", payload.getMessage()));
    }
}
