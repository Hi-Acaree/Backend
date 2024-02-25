package org.acaree.web;

public class ApiMappings {

    //== DoctorController ApiRoutes ==
    public static final String BASE_URL = "/api/v1/doctor";
    public static final String ADD_DOCTOR_URL = "/add";
    public static final String UPDATE_DOCTOR_URL = "/update";
    public static final String DELETE_DOCTOR_BY_ID_URL = "/{id}/delete";
    public static final String GET_DOCTOR_BY_ID_URL = "/{id}";
    public static final String GET_ALL_DOCTORS_URL = "/all";
    public static final String GET_DOCTORS_BY_SPECIALIZATION_URL = "/specialization";
    public static final String GET_DOCTORS_APPOINTMENTS_BY_PATIENT_ID = "/appointments/{id}/patientId";
    public static final String GET_DOCTORS_APPOINTMENTS_BY_PATIENT_ID_BY_TIME_SLOT_ID = "/appointments/{id}/patient/{patientId}/timeslotId";
    public static final String GET_DOCTORS_APPOINTMENTS_BY_ID = "/appointments/{id}";
    public static final String GET_DOCTORS_APPOINTMENTS_BY_TIME_SLOT_ID = "/appointments/{id}/timeslotId";
    public static final String GET_DOCTORS_BY_DEPARTMENT_URL = "/department";
    public static final String SET_DOCTOR_AVAILABILITY_URL = "/availability/{id}/set";
    public static final String REMOVE_DOCTOR_AVAILABILITY_URL = "/availability/{id}/remove";
    public static final String UPDATE_DOCTOR_WEEKLY_SCHEDULE_URL = "/schedule/{id}";
    public static final String GET_DOCTOR_AVAILABILITY_URL = "/availability";
    public static final String  GET_DOCTOR_UNAVAILABLE_DAYS_URL = "/unavailableDays/{id}";

    //== AppointmentController ApiRoutes ==
    public static final String APPOINTMENT_BASE_URL = "/api/v1/appointment";
    public static final String BOOK_APPOINTMENT_BY_PATIENT_URL = "/book/appointment";

    public static final String ASSIGN_APPOINTMENT_TO_DOCTOR_URL = "/assign/{id}/doctor/{doctorId}/timeslot/{timeSlotId}";
    public static final String RESCHEDULE_APPOINTMENT_URL = "/reschedule/{id}/timeslot/{timeSlotId}";
    public static final String CANCEL_APPOINTMENT_URL = "/cancel/{id}";
    public static final String UPDATE_APPOINTMENT_URL = "/update";
    public static final String GET_APPOINTMENT_BY_ID_URL = "/{id}";
    public static final String GET_ALL_APPOINTMENTS_URL = "/all";
    public static final String GET_ALL_APPOINTMENTS_BY_DOCTOR_ID_URL = "/doctor/{doctorId}";
    public static final String GET_ALL_APPOINTMENTS_BY_PATIENT_ID_URL = "/patient/{patientId}";
    public static final String SCHEDULE_RECURRING_APPOINTMENT_URL = "/schedule/recurring";
    public static final String GET_AVAILABLE_TIME_SLOTS_FOR_DOCTOR_DAY_URL = "/availableTimeSlots";

    //== PatientController ApiRoutes ==
    public static final String PATIENT_BASE_URL = "/api/v1/patient";
    public static final String ADD_PATIENT_URL = "/add";
    public static final String UPDATE_PATIENT_URL = "/update";
    public static final String DELETE_PATIENT_BY_ID_URL = "/{id}/delete";
    public static final String GET_PATIENT_BY_ID_URL = "/{id}";
    public static final String GET_ALL_PATIENTS_URL = "/all";

    //== Person Controller ApiRoutes ==

    public static final String PERSON_BASE_URL = "/api/v1/person";
    public static final String UPLOAD_IMAGE_URL = "/{id}/image";
    public static final String GET_IMAGE_URL = "/{id}/image";


}
