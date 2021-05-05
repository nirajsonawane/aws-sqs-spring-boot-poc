package com.ns.awssqspoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Publisher {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        log.info("Sending Message to SQS ");
        //queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload("Niraj").build());
        queueMessagingTemplate.convertAndSend(endpoint, new Pojo("SomeRandomValue"));

    }
}
