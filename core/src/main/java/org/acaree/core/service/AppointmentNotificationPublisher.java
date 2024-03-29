package org.acaree.core.service;
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
    private final JmsTemplate jmsTemplate; // JMS template to be injected

    @Autowired
    public AppointmentNotificationPublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * Constructor for AppointmentNotificationPublisher.
     * @param message the message to be published.
     * @param destination the destination where the message is to be published.
     * {@code @JmsTemplate} the JMS template to use.
     */

    public void publishMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }


}
