package org.acaree.web.controller;

import org.acaree.core.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentNotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public AppointmentNotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyNewAppointment(Appointment appointment) {
        messagingTemplate.convertAndSend("/topic/newAppointment", appointment);
    }
}
