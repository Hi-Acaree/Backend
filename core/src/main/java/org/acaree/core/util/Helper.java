package org.acaree.core.util;

import org.acaree.core.model.Appointment;
import org.acaree.core.model.Person;

import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;

public class Helper {

    /**
     * Generate a business key for a person.
     *
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
     * @param appointment The appointment for which the business key is to be generated.
     * @return The business key for the appointment.
     * @see Appointment
     */


    public static String generateBusinessKey(@NotNull Appointment appointment) {
        // Formatting the date and time separately
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");

        String patientId = appointment.getPatient() != null ? String.valueOf(appointment.getPatient().getId()) : "null";
        String doctorId = appointment.getDoctor() != null ? String.valueOf(appointment.getDoctor().getId()) : "null";

        // Formatting date and time
        String date = appointment.getDate() != null ? appointment.getDate().format(dateFormatter) : "null";
        String time = appointment.getTime() != null ? appointment.getTime().format(timeFormatter) : "null";

        return patientId + "_" + doctorId + "_" + date + "_" + time;
    }


}

