package org.acaree.core.exceptions;

public class DoctorException extends CustomAppExceptions{
    public DoctorException(String message) {
        super(message);
    }

    public static class DoctorHasAppointmentsException extends DoctorException {
        public DoctorHasAppointmentsException(String message) {
            super(message);
        }
    }
}
