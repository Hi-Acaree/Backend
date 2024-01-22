package org.acaree.core.model;

import lombok.*;

/**
 * This class is a model class for AppointmentNotificationMessage.
 * It contains information about an appointment notification message.
 * {@code @Getter} and {@code @Setter} annotation to generate getter and setter methods for all fields.
 * {@code @NoArgsConstructor} annotation to generate a no argument constructor.
 * {@code @EqualsAndHashCode} annotation to generate equals and hashcode methods.
 * {@code @ToString} annotation to generate toString method.
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

    /**
     * Constructor for AppointmentNotificationMessage.
     * @param appointmentId the appointment id.
     * @param patientId the patient id.
     * @param doctorId the doctor id.
     * @param message the message.
     */
    public AppointmentNotificationMessage(Long appointmentId, Long patientId, Long doctorId, String message) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.message = message;
    }
}
