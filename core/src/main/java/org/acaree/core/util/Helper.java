package org.acaree.core.util;

import jakarta.validation.Valid;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Person;
import org.acaree.core.model.TimeSlot;
import java.time.format.DateTimeFormatter;

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
    public static String generateBusinessKey(Person personDetails) {
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


    public static String generateBusinessKey(Appointment appointment) {
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


}

