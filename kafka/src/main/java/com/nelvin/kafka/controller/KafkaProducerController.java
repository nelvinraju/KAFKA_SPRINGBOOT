package com.nelvin.kafka.controller;

import com.nelvin.kafka.dto.Message;
import com.nelvin.kafka.service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

    private final KafKaProducerService producerService;

    @Autowired
    public KafkaProducerController(KafKaProducerService producerService)
    {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestBody Message message)
    {
        try {
            System.out.println("before sending message");
            this.producerService.sendMessage(message);
            System.out.println("after sending message");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "message send";
    }
}
