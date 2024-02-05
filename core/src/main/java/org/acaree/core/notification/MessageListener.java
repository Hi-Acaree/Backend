package org.acaree.core.notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.model.AppointmentNotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
    private  final JavaMailSender mailSender;

    private final ObjectMapper objectMapper;
    @Autowired
    public MessageListener(JavaMailSender mailSender, ObjectMapper objectMapper) {
        this.mailSender = mailSender;
        this.objectMapper = objectMapper;
    }

    @JmsListener(destination = "appointment-queue")
    public void receive(String messageJson) {
        log.info("Message received: {}", messageJson);
        try {
            AppointmentNotificationMessage message = objectMapper.readValue(messageJson, AppointmentNotificationMessage.class);
            log.info("Sending email to: {}", message.getEmail());
            // send email
            sendEmail(message);
        } catch (Exception e) {
            log.error("Error occurred while processing the message: {}", e.getMessage());
        }

    }

    private void sendEmail(AppointmentNotificationMessage message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(message.getEmail());
        log.info("Sending email to: {}", message.getEmail());
        mailMessage.setSubject("Appointment Confirmation");
        mailMessage.setText(buildEmailText(message));
        mailSender.send(mailMessage); // send email
        log.info("Email sent to: {}", Objects.requireNonNull(mailMessage.getTo())[0]);
    }

    private String buildEmailText(AppointmentNotificationMessage message) {
       // construct a more detailed message based on the AppointmentNotificationMessage object
       StringBuilder sb = new StringBuilder();
       sb.append("Your appointment with Dr. ");
         sb.append(message.getDoctorName());
            sb.append(" is confirmed for ");
            sb.append(message.getAppointmentType());
            sb.append(" on ");
            sb.append(message.getTimeSlot().getDate());
            sb.append(" at ");
            sb.append(message.getTimeSlot().getStartTime());
            sb.append(" to ");
            sb.append(message.getTimeSlot().getEndTime());
            sb.append(".");
            return sb.toString();

    }


}
