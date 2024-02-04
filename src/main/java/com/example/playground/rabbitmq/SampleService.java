package com.example.playground.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleService {

    @RabbitListener(queues = "sample-queue")
    public void sample(String message) {
        log.info("message: {}", message);
    }
}
