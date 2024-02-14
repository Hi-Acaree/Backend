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
@EqualsAndHashCode(of = {"doctorName", "appointmentType", "timeSlot", "message"})
@ToString
public class AppointmentNotificationMessage {
    private String doctorName;
    private String email;
    private String appointmentType;
    private TimeSlot timeSlot;
    private String message;

    // Constructor

    /**
     * Constructor for AppointmentNotificationMessage.
     * @param doctorName the name of the doctor.
     * @param email the email of the patient.
     * @param appointmentType the type of appointment. i.e., virtual or inPerson.
     * @param timeSlot the time slot of the appointment.
     * @param message the message.
     */
    public AppointmentNotificationMessage(String doctorName, String email, String appointmentType, TimeSlot timeSlot,
                                          String message) {
        this.doctorName = doctorName;
        this.email = email;
        this.appointmentType = appointmentType;
        this.timeSlot = timeSlot;
        this.message = message;
    }
}
