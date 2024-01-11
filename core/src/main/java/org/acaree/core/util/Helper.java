package org.acaree.core.util;

import org.acaree.core.model.Appointment;
import org.acaree.core.model.AppointmentNotificationMessage;
import org.acaree.core.model.Person;
import org.acaree.core.model.TimeSlot;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Helper {

    /**
     * Generate a business key for a person.
     * <p>
     * This method generates a business key for a person.
     * The business key should be based on attributes that are immutable
     * and unique to each Person.
     *
     * @param personDetails The person for whom the business key is to be generated.
     * @return The business key for the person.
     */
    public static String generateBusinessKey(@Valid Person personDetails) {
        return personDetails.getEmail() + "_" + personDetails.getPhone();
    }


    /**
     * Generates a business key for an appointment.
     * This method generates a business key for an appointment.
     * The business key should be based on attributes that are immutable
     * and unique to each Appointment.
     *
     * @param appointment The appointment for which the business key is to be generated.
     * @return The business key for the appointment.
     * @see Appointment
     */


    public static String generateBusinessKey(@Valid Appointment appointment) {
        // Formatting the time separately
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");

        String patientId = appointment.getPatient() != null ? String.valueOf(appointment.getPatient().getId()) : "null";
        String doctorId = appointment.getDoctor() != null ? String.valueOf(appointment.getDoctor().getId()) : "null";

        // Formatting date and time
        TimeSlot timeSlot = appointment.getTimeSlot();
        String startTime = timeSlot != null ? timeSlot.getStartTime().format(timeFormatter) : "null";
        String endTime = timeSlot != null ? timeSlot.getEndTime().format(timeFormatter) : "null";

        return patientId + "_" + doctorId + "_" + startTime + "_" + endTime;
    }

    /**
     * Generates a business key for a time slot.
     * This method generates a business key for a time slot.
     * The business key should be based on attributes that are immutable
     * and unique to each TimeSlot.
     *
     * @param timeSlot The time slot for which the business key is to be generated.
     * @return The business key for the time slot.
     * @see TimeSlot
     */

    public static String generateBusinessKey(@Valid TimeSlot timeSlot) {
        // Formatting the time separately
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");

        String doctorId = timeSlot.getDoctor() != null ? String.valueOf(timeSlot.getDoctor().getId()) : "null";

        // Formatting date and time
        String startTime = timeSlot.getStartTime() != null ? timeSlot.getStartTime().format(timeFormatter) : "null";
        String endTime = timeSlot.getEndTime() != null ? timeSlot.getEndTime().format(timeFormatter) : "null";

        return doctorId + "_" + startTime + "_" + endTime;

    }


}

