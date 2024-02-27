package org.acaree.core.notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.config.EmailConfig;
import org.acaree.core.model.AppointmentNotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
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
    private final Environment env;
    private  final JavaMailSender mailSender;

    private final ObjectMapper objectMapper;
    private final TemplateEngine templateEngine;
    @Autowired
    public MessageListener(JavaMailSender mailSender, ObjectMapper objectMapper,
                           TemplateEngine templateEngine,
                            Environment env
    ) {
        this.mailSender = mailSender;
        this.objectMapper = objectMapper;
        this.templateEngine = templateEngine;
        this.env = env;
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
            sendAppointmentEmail(message);
        } catch (Exception e) {
            log.error("Error occurred while processing the message: {}", e.getMessage());
        }

    }

//    /**
//     * This method is used to send the email.
//     * @param message The message to be sent.
//     */

    public void sendAppointmentEmail(AppointmentNotificationMessage messageObject) {

        var dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");  // Example: Monday, January 1, 2024
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a"); // Example: 9:00 AM

        String dateFormatted = messageObject.getTimeSlot().getDate().format(dateFormatter);
        String startTimeFormatted = messageObject.getTimeSlot().getStartTime().format(timeFormatter);
        String endTimeFormatted = messageObject.getTimeSlot().getEndTime().format(timeFormatter);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()); // true for multipart message

            Context context = new Context(); // Thymeleaf context
            context.setVariable("doctorName", messageObject.getDoctorName());
            context.setVariable("appointmentType", messageObject.getAppointmentType());
            context.setVariable("date", dateFormatted);
            context.setVariable("startTime", startTimeFormatted);
            context.setVariable("endTime", endTimeFormatted);

            String html = templateEngine.process("appointment-confirmation.html", context); // process the html template

            if (!isValidEmail(messageObject.getEmail())) {
                log.error("Invalid email: {}", messageObject.getEmail());
                return;
            }


            helper.setTo(messageObject.getEmail());
            helper.setText(html, true);
            helper.setSubject("Appointment Confirmation");
            helper.setFrom(Objects.requireNonNull(env.getProperty("EMAIL_FROM")));
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
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



}
