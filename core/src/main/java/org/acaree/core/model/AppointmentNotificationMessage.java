package org.acaree.core.model;

import lombok.*;

/**
 * This class is a model class for AppointmentNotificationMessage.
 * It contains information about an appointment notification message.
 * @Getter and @Setter lombok annotations to generate getters and setters for all fields.
 * @NoArgsConstructor lombok annotation to generate a no-args constructor.
 * @EqualsAndHashCode lombok annotation to generate equals and hashCode methods.
 * @ToString lombok annotation to generate toString method.
 *
 */
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"appointmentId", "patientId", "doctorId", "message"})
@ToString
public class AppointmentNotificationMessage {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private String message;

    // Constructor
    public AppointmentNotificationMessage(Long appointmentId, Long patientId, Long doctorId, String message) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.message = message;
    }
}
