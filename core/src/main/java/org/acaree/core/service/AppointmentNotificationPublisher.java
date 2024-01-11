package org.acaree.core.service;

import org.acaree.core.model.AppointmentNotificationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is used to publish messages to the RabbitMQ broker.
 * The RabbitTemplate is injected using the @Autowired annotation.
 * The publishMessage method is used to publish messages to the broker.
 * The convertAndSend method is used to convert the message to a byte array and send it to the broker.
 * The first parameter is the exchange name, the second parameter is the routing key and the third parameter is the message.
 * The exchange name and the routing key are used by the broker to route the message to the appropriate queue.
 * The exchange name and the routing key are configured in the application.yaml file.
 */

@Service
public class AppointmentNotificationPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishMessage(String queName, AppointmentNotificationMessage message) {
        rabbitTemplate.convertAndSend(queName, message);
    }


}
