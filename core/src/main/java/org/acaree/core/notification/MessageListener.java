package org.acaree.core.notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.model.AppointmentNotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MessageListener is a class that listens to the messages from the queue.
 * <p>This class is used to listen to the messages from the queue.</p>
 * <p>This class is used by the NotificationService class.</p>
 * {@code @Component} annotation to indicate that this class is a component.
 * {@code @Slf4j} annotation to generate a logger field.
 * {@code @Autowired} annotation to inject the dependencies.
 * {@code @JmsListener} annotation to listen to the messages from the queue.
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

    /**
     * This method is used to receive the message from the queue.
     * @param messageJson The message to be received in json fmt.
     * {@code @JmsListener} annotation to listen to the messages from the queue.
     * @see AppointmentNotificationMessage The message to be received.
     * {@code @Slf4j} annotation to generate a logger field.
     * @see ObjectMapper The object mapper to be used.
     */

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

    /**
     * This method is used to send the email.
     * @param message The message to be sent.
     */

    private void sendEmail(AppointmentNotificationMessage message) {
        if (!isValidEmail(message.getEmail())) {
            log.error("Invalid email: {}", message.getEmail());
            return;
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String emailFrom = System.getenv("EMAIL_FROM"); // get from email (environment variable)
        if (emailFrom == null) {
            log.error("Email from is not set");
            return;
        }
        mailMessage.setFrom(emailFrom); // set from email (environment variable)
        mailMessage.setSubject("Appointment Confirmation");
        mailMessage.setTo(message.getEmail());
        log.info("Sending email to: {}", message.getEmail());
        mailMessage.setSubject("Appointment Confirmation");
        mailMessage.setText(buildEmailText(message));
        mailSender.send(mailMessage); // send email
        log.info("Email sent to: {}", Objects.requireNonNull(mailMessage.getTo())[0]);
    }

    /**
     * This method is used to validate the email.
     * @param email The email to be validated.
     * @return true if the email is valid, false otherwise.
     */

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * This method is used to build the email text.
     * @param message The message to be used to build the email text.
     * @return The email text.
     */

    private String buildEmailText(AppointmentNotificationMessage message) {
       // construct a more detailed message based on the AppointmentNotificationMessage object
       StringBuilder sb = new StringBuilder();
       sb.append("Your, ");
            sb.append(message.getAppointmentType());
            sb.append(" appointment with ");
            sb.append(message.getDoctorName());
            sb.append(" is confirmed, for date: ");
            sb.append(message.getTimeSlot().getDate());
            sb.append(" at ");
            sb.append(message.getTimeSlot().getStartTime());
            sb.append(" to ");
            sb.append(message.getTimeSlot().getEndTime());
            sb.append(".");
            return sb.toString();

    }


}
