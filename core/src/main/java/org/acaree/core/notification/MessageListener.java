package org.acaree.core.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * MessageListener is a class that listens to the messages from the queue.
 * <p>This class is used to listen to the messages from the queue.</p>
 * <p>This class is used by the NotificationService class.</p>
 * {@code @Component} annotation to indicate that this class is a component.
 * {@code @Slf4j} annotation to generate a logger field.
 */

@Component
@Slf4j
public class MessageListener {
    @JmsListener(destination = "acaree-exchange")
    public void receive(String message) {
        log.info("Message received: {}", message);

        //process the message



    }


}
