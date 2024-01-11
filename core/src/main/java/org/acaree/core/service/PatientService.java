package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.PatientException;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.Patient;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //== public methods ==


    /**
     * This method is used to save a patient to the database.
     *
     * @param patient the patient to be saved.
     * @return the saved patient.
     * @throws PatientException if patient object is null.
     * @Transactional is used to mark the method as a transactional method.
     */

    public Patient savePatient(Patient patient) {
        if (Objects.isNull(patient)) {
            log.error("Patient object cannot be null");
            throw new PatientException("Patient object cannot be null");

        }
        Patient savedPatient = patientRepository.save(patient);
        log.info("Saved patient with id: {}", savedPatient.getId());
        return savedPatient;
    }

    /**
     * This method is used to get a patient by id.
     *
     * @param id the id of the patient.
     * @return the patient with the given id.
     * @throws PatientException if patient with id is not found.
     * @Transactional(readOnly = true is used to mark the method as read only, so that the transaction manager
     * doesn't get involved in the transaction.
     */

    public Optional<Patient> getPatientById(long id) {
        if (id < 0) {
            throw new PatientException("Invalid patient ID");
        }

        Optional<Patient> patient = patientRepository.findById(id);
        if (!patient.isPresent()) {
            throw new PatientException("Patient with id: " + id + " not found");
        }
        log.info("Retrieved patient with id: {}", id);
        return patient;



    }

    /**
     * This method is used to get all patients.
     *
     * @return all patients.
     * @Transactional(readOnly = true is used to mark the method as read only, so that the transaction manager
     * doesn't get involved in the transaction.
     */

    public Iterable<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(patient -> log.info("Retrieved patient with id: {}", patient.getId()));

        return patients;
    }

    /**
     * This method is used to delete a patient by id.
     *
     * @param id the id of the patient.
     * @throws PatientException if patient with id is not found.
     * @Transactional is used to mark the method as a transactional method.
     */

    public void deletePatientById(long id) {
        // Check if patient exists
        Patient patient =
                patientRepository.findById(id).orElseThrow(()
                        -> new PatientException("Patient with id: " + id + " not found"));

        // Delete patient
        patientRepository.delete(patient);

    }

    /**
     * This method is used to update a patient.
     *
     * @param patient the patient to be updated.
     * @return the updated patient.
     * @throws PatientException if patient object is null.
     * @Transactional is used to mark the method as a transactional method.
     */

    /**
     * Updates the details of an existing patient in the database.
     * @param patient The patient object to be updated.
     * @Transactional is used to mark the method as a transactional method.
     * @return The updated patient object.
     * @throws PatientException if the patient object is null or if no patient is found with the given id.
     */

    @Transactional
    public Patient updatePatient(Patient patient) {
        if (Objects.isNull(patient)) {
            throw new PatientException("Patient object cannot be null");
        }

        // Check if patient exists
        long id = patient.getId();
        patientRepository.findById(id).orElseThrow(()
                -> new PatientException("Patient with id: " + patient.getId() + " not found"));

        // Update patient
        Patient updatedPatient = patientRepository.save(patient);
        log.info("Patient with id: {} updated", patient.getId());

        return updatedPatient;
    }

    /**
     * This method is used to delete patient by id.
     * @param id the id of the patient to be deleted.
     * @Transactional is used to mark the method as a transactional method.
     * @throws PatientException if patient with id is not found.
     * @throws PatientException if patient has appointments.
     *
     */

    @Transactional
    public void deletePatient(long id) {
        // Check if patient exists
        Patient patient =
                patientRepository.findById(id).orElseThrow(()
                        -> new PatientException("Patient with id: " + id + " not found"));

        // Check if patient has appointments

        if (patient.getAppointments() != null && !patient.getAppointments().isEmpty()) {
            throw new PatientException("Patient with id: " + id + " has appointments");
        }
        // Delete patient
        patientRepository.deleteById(id);
        log.info("Patient with id: {} deleted", id);

    }





}
