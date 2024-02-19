package org.acaree.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acaree.core.model.Appointment;
import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private long id;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private TimeSlotDTO timeSlot;
    private String reason;
    private String type;
    private boolean booked;

    public static AppointmentDTO from(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        Objects.requireNonNull(appointment, "Appointment cannot be null");
        dto.setId(appointment.getId());
        dto.setPatient(PatientDTO.from(appointment.getPatient()));
        dto.setDoctor(DoctorDTO.from(appointment.getDoctor()));
        dto.setTimeSlot(TimeSlotDTO.from(appointment.getTimeSlot()));
        dto.setReason(appointment.getReason());
        dto.setType(appointment.getType());
        dto.setBooked(appointment.isBooked());

        return dto;

    }


}
