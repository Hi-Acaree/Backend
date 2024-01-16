package org.acaree.core.service;

import org.acaree.core.model.AppointmentNotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * This class is used to publish messages to the ActiveMQ broker.
 * The JMS template is injected using the @Autowired annotation.
 * The publishMessage method is used to publish messages to the broker.
 * The convertAndSend method is used to convert the message to a byte array and send it to the broker.
 */

@Service
public class AppointmentNotificationPublisher {


    @Autowired
    private JmsTemplate jmsTemplate;

    public void publishMessage(String destination, AppointmentNotificationMessage message) {
        jmsTemplate.convertAndSend(destination, message);
    }


}
