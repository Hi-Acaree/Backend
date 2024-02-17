package org.acaree.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acaree.core.exceptions.DoctorException;
import org.acaree.core.exceptions.PatientException;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.Appointment;
import org.acaree.core.util.ErrorType;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private long id;
    private long patientId;
    private long doctorId;
    private long timeSlotId;
    private String reason;
    private String type;
    private boolean booked;

    public static AppointmentDTO from(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        Objects.requireNonNull(appointment, "Appointment cannot be null");
        if (appointment.getPatient() == null) {
            throw new PatientException("Patient cannot be null", ErrorType.PATIENT_NOT_FOUND);
        }
        if (appointment.getDoctor() == null) {
            throw new DoctorException("Doctor cannot be null", ErrorType.DOCTOR_NOT_FOUND);
        }
        if (appointment.getTimeSlot() == null){
            throw new TimeSlotException("Time slot is null", ErrorType.TIMESLOT_NOT_FOUND);
        }

        dto.setId(appointment.getId());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setTimeSlotId(appointment.getTimeSlot().getId());
        dto.setReason(appointment.getReason());
        dto.setType(appointment.getType());
        dto.setBooked(appointment.isBooked());
        return dto;
    }


}
