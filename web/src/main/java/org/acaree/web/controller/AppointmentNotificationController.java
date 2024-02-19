package org.acaree.web.controller;

import org.acaree.core.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class AppointmentNotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void notifyNewAppointment(Appointment appointment) {
        messagingTemplate.convertAndSend("/topic/newAppointment", appointment);
    }
}
