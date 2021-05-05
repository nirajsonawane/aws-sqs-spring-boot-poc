package com.ns.awssqspoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @SqsListener(value = "spring-boot-poc",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(Pojo message) {
        log.info("Message from SQS {}", message);
    }
}
