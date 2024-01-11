package org.acaree.core.model;

import lombok.*;

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
