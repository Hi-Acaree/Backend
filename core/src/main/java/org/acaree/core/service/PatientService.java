package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.PatientException;
import org.acaree.core.model.*;
import org.acaree.core.repository.PatientRepository;
import org.acaree.core.repository.PersonRepository;
import org.acaree.core.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class is used to implement the business logic for the patient.
 * It is used to perform CRUD operations on the patient.
 * {@code @Service} annotation is used to mark the class as a service.
 * {@code @Slf4j} annotation is used to enable logging.
 * {@code @Autowired} annotation is used to inject the PatientRepository dependency.
 * {@code @Transactional} annotation is used to mark the method as a transactional method.
 * <p> This class is used by the PatientController class.</p>
 * <p> This class is used by the AppointmentService class.</p>
 * <p> This class is used by the DoctorService class.</p>
 * <p> This class is used by the TimeSlotService class.</p>
 *
 */

@Service
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;
    private final PersonRepository personRepository;

    /**
     * Constructor for PatientService.
     * @param patientRepository the patient repository to be injected.
     * @param personRepository the person repository to be injected.
     * {@code @Autowired } annotation is used to inject the PatientRepository and PersonRepository dependencies.
     */

    @Autowired
    public PatientService(PatientRepository patientRepository,
                          PersonRepository personRepository) {
        this.patientRepository = patientRepository;
        this.personRepository = personRepository;
    }

    //== public methods ==


    /**
     * This method is used to save a patient to the database.
     *
     * @param patient the patient to be saved.
     * @return the saved patient.
     * @throws PatientException if patient object is null.
     * {@code @Transactional} annotation is used to mark the method as a transactional method.
     */

    public Patient savePatient(Patient patient) {
        if (Objects.isNull(patient)) {
            log.error("Patient object cannot be null");
            throw new PatientException("Patient object cannot be null", ErrorType.PATIENT_INVALID_INPUT);

        }
        Patient savedPatient = patientRepository.save(patient);
        log.info("Saved patient with id: {}", savedPatient.getId());
        return savedPatient;
    }

    public Patient ensureTemporaryRecordOfPatient(String email) {
        return patientRepository.findByEmail(email).orElseGet(() -> {
            Person person = new Person("Anonymous", "Patient", email, "1234567890");
            person = personRepository.save(person); // Save person first

            Patient patient = new Patient();
            patient.setPersonDetails(person);
            patient.setExpiry(LocalDateTime.now().plusDays(30)); // Set expiry for temporary record
            return patientRepository.save(patient); // Save patient with associated person
        });
    }


    /**
     * This method is used to get a patient by id.
     *
     * @param id the id of the patient.
     * @return the patient with the given id.
     * @throws PatientException if patient with id is not found.
     * doesn't get involved in the transaction.
     */

    public Patient getPatientById(long id) {
        if (id < 0) {
            throw new PatientException("Invalid patient ID", ErrorType.PATIENT_INVALID_INPUT);
        }

        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientException("Patient with id: " + id + " not found",
                        ErrorType.PATIENT_NOT_FOUND));
    }


    /**
     * This method is used to get all patients.
     * @return all patients.
     */

    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(patient -> log.info("Retrieved patient with id: {}", patient.getId()));

        return patients;
    }

    /**
     * Updates the details of an existing patient in the database.
     * @param patient The patient object to be updated.
     * @return The updated patient object.
     * @throws PatientException if the patient object is null or if no patient is found with the given id.
     */

    @Transactional
    public Patient updatePatient(Patient patient) {
        if (Objects.isNull(patient)) {
            throw new PatientException("Patient object cannot be null",
                    ErrorType.PATIENT_INVALID_INPUT);
        }

        // Check if patient exists
        long id = patient.getId();
        patientRepository.findById(id).orElseThrow(()
                -> new PatientException("Patient with id: " + patient.getId() + " not found",
                        ErrorType.PATIENT_NOT_FOUND));

        // Update patient
        Patient updatedPatient = patientRepository.save(patient);
        log.info("Patient with id: {} updated", patient.getId());

        return updatedPatient;
    }

    /**
     * This method is used to delete patient by id.
     * @param id the id of the patient to be deleted.
     * @throws PatientException if patient with id is not found.
     * @throws PatientException if patient has appointments.
     *
     */

    @Transactional
    public void deletePatient(long id) {
        // Check if patient exists
        Patient patient =
                patientRepository.findById(id).orElseThrow(()
                        -> new PatientException("Patient with id: " + id + " not found",
                                ErrorType.PATIENT_NOT_FOUND));

        // Check if patient has appointments

        if (patient.getAppointments() != null && !patient.getAppointments().isEmpty()) {
            throw new PatientException.PatientHasAppointmentsException("Patient with id: " + id + " has appointments");
        }
        // Delete patient
        patientRepository.deleteById(id);
        log.info("Patient with id: {} deleted", id);

    }
}
