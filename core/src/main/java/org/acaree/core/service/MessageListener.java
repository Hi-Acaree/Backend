package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {
    @RabbitListener(queues = "acaree-exchange")
    public void listen(String message) {
        log.info("Message received: {}", message);

        //process the message

    }


}
