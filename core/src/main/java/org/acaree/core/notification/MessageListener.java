package org.acaree.core.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class MessageListener {
    @JmsListener(destination = "acaree-exchange")
    public void receive(String message) {
        log.info("Message received: {}", message);

        //process the message



    }


}
