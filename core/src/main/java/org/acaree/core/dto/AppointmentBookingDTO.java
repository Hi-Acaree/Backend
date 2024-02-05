package org.acaree.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.model.TimeSlot;

@Slf4j
@Getter @Setter
@NoArgsConstructor
public class AppointmentBookingDTO {
    private long doctorId;
    private String patientEmail;
    private String patientName;
    private long timeSlotId;
    private String reason;

    public AppointmentBookingDTO(long doctorId, String patientEmail, String patientName, long timeSlotId, String reason) {
        this.doctorId = doctorId;
        this.patientEmail = patientEmail;
        this.patientName = patientName;
        this.timeSlotId = timeSlotId;
        this.reason = reason;
    }
}
