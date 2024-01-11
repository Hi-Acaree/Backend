package org.acaree.core.notification;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is used to configure the RabbitMQ broker.
 * The queue method is used to create a queue with the name acaree-exchange.
 * The queue is created as a non-durable, non-exclusive, auto-delete queue.
 */

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue queue() {
        return new Queue("acaree-exchange", false);
    }

    // Optionally define an Exchange and Binding if you need more than the default
}

