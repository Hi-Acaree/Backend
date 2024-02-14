package org.acaree.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a model class for AppointmentBookingDTO.
 * It contains information about an appointment booking.
 * {@code @Getter} and {@code @Setter} annotation to generate getter and setter methods for all fields.
 * {@code @NoArgsConstructor} annotation to generate a no argument constructor.
 * {@code @Slf4j} annotation to generate a logger field.
 *
 */

@Slf4j
@Getter @Setter
@NoArgsConstructor
public class AppointmentBookingDTO {
    private long doctorId;
    private String email;
    private String patientName;
    private long timeSlotId;
    private String reason;
    private String type;

    public AppointmentBookingDTO(long doctorId, String patientEmail,
                                 String patientName, long timeSlotId, String reason,
                                 String type) {
        this.doctorId = doctorId;
        this.email = patientEmail;
        this.patientName = patientName;
        this.timeSlotId = timeSlotId;
        this.reason = reason;
        this.type = type;
    }
}
