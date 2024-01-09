package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.DoctorException;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * This class is a service class for Doctor.
 * <p> This class is used to perform CRUD operations
 * and other custom queries on the Doctor class.
 * </p>
 * @see Doctor
 * @see DoctorRepository
 * @see DoctorException
 *
 */

@Service
@Slf4j
public class DoctorService {
    private final DoctorRepository doctorRepository;
    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    /**
     * This method is used to save a doctor to the database.
     * @param doctor the doctor to be saved.
     * @Transactional is used to mark the method as a transactional method.
     * @throws DoctorException if doctor object is null.
     * @return the saved doctor.
     */

    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
           if (Objects.isNull(doctor)) {
                throw new DoctorException("Doctor object cannot be null");
            }
           Doctor savedDoctor = doctorRepository.save(doctor);
              log.info("Saved doctor with id: {}", savedDoctor.getId());
                return savedDoctor;
    }

    /**
     * This method is used to get a doctor by id.
     * @param id the id of the doctor.
     * @throws DoctorException if doctor with id is not found.
     * @Transactional(readOnly = true is used to mark the method as read only, so that the transaction manager
     * doesn't get involved in the transaction.
     * @return the doctor with the given id.
     */

    @Transactional(readOnly = true)
    public Optional<Doctor> getDoctorById(long id) {
        if (id < 0) {
            throw new DoctorException("Doctor with id: " + id + " not found");
        }
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()
                -> new DoctorException("Doctor with id: " + id + " not found"));
        log.info("Doctor with id: {} found", id);

        return Optional.of(doctor);
    }

    /**
     * This method is used to delete a doctor by id.
     * @param id the id of the doctor to be deleted.
     * @Transactional is used to mark the method as a transactional method.
     * @throws DoctorException if doctor with id is not found or if doctor has appointments.
     */
    @Transactional
    public void deleteDoctorById(long id) {
        // Check if doctor exists
        Doctor doctor =
          doctorRepository.findById(id).orElseThrow(()
                  -> new DoctorException("Doctor with id: " + id + " not found"));

        // Check if doctor has appointments

        if (doctor.getAppointments() != null && !doctor.getAppointments().isEmpty()) {
            throw new DoctorException("Doctor with id: " + id + " has appointments");
        }
        // Delete doctor
        doctorRepository.deleteById(id);
        log.info("Doctor with id: {} deleted", id);

    }

    /**
     * This method is used to update a doctor.
     * @param doctor the doctor to be updated.
     * @throws DoctorException if doctor object is null or if doctor with id is not found.
     * @return the updated doctor.
     */
    @Transactional
    public Doctor updateDoctor(Doctor doctor) {
        if (Objects.isNull(doctor)) {
            throw new DoctorException("Doctor object cannot be null");
        }
        // Check if doctor exists
        doctorRepository.findById(doctor.getId()).orElseThrow(()
                -> new DoctorException("Doctor with id: " + doctor.getId() + " not found"));
        long id = doctor.getId();
        log.info("Doctor with id: {} updated", id);

        // Update doctor
        return doctorRepository.save(doctor);
    }

    /**
     * This method is used to get all doctors.
     * @return all doctors.
     */
    @Transactional(readOnly = true)
    public Iterable<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }

    /**
     * This method is used to get all appointments of a doctor.
     * @param doctorId the id of the doctor.
     * doesn't get involved in the transaction.
     * @return all appointments of the doctor.
     */

    @Transactional(readOnly = true)
    public List<Appointment> getDoctorsAppointments(Long doctorId) {
        if(Objects.isNull(doctorId)) {
            throw new DoctorException("Doctor id cannot be null");
        }
        List<Appointment> appointments = doctorRepository.getDoctorsAppointments(doctorId);
        if (appointments.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved appointments of doctor with id: {}", doctorId);
        return appointments;

    }

    /**
     * This method is used to get all doctors by specialization.
     * @param specialization the specialization of the doctor.
     * doesn't get involved in the transaction.
     * @return all doctors with the given specialization.
     */

    @Transactional(readOnly = true)
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        if (Objects.isNull(specialization)) {
            throw new DoctorException("Specialization cannot be null");
        }
        List<Doctor> doctors = doctorRepository.getDoctorsBySpecialization(specialization);
        if (doctors.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved doctors with specialization: {}", specialization);
        return doctors;
    }

    /**
     * This method is used to get all appointments of a doctor by patient id.
     * @param doctorId the id of the doctor.
     * @param patientId the id of the patient.
     * doesn't get involved in the transaction.
     * @return all appointments of the doctor with the given patient id.
     */

    @Transactional(readOnly = true)
    public List<Appointment> getDoctorsAppointmentsByPatientId(Long doctorId, Long patientId) {
        if(Objects.isNull(doctorId) || Objects.isNull(patientId)) {
            throw new DoctorException("Doctor id or patient id cannot be null");
        }
        List<Appointment> appointments = doctorRepository.getDoctorsAppointmentsByPatientId(doctorId, patientId);
        if (appointments.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved appointments of doctor with id: {} and patient id: {}", doctorId, patientId);
        return appointments;
    }

    /**
     * This method is used to get all appointments of a doctor by patient id and time slot id.
     * @param doctorId the id of the doctor.
     * @param patientId the id of the patient.
     * @param timeSlotId the id of the time slot.
     * doesn't get involved in the transaction.
     * @return all appointments of the doctor with the given patient id and time slot id.
     */

    @Transactional(readOnly = true)
    public List<Appointment> getDoctorsAppointmentsByPatientIdAndTimeSlotId(Long doctorId, Long patientId, Long timeSlotId) {
        if(Objects.isNull(doctorId) || Objects.isNull(patientId) || Objects.isNull(timeSlotId)) {
            throw new DoctorException("Doctor id or patient id or time slot id invalid");
        }
        List<Appointment> appointments = doctorRepository.getDoctorsAppointmentsByPatientIdAndTimeSlotId(doctorId, patientId, timeSlotId);
        if (appointments.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved appointments of doctor with id: {}, patient id: {} and time slot id: {}", doctorId, patientId, timeSlotId);
        return appointments;
    }

    /**
     * This method is used to get all appointments of a doctor by time slot id.
     * @param doctorId the id of the doctor.
     * @param timeSlotId the id of the time slot.
     * @return all appointments of the doctor with the given time slot id.
     */

    @Transactional(readOnly = true)
    public List<Appointment> getDoctorsAppointmentsByTimeSlotId(Long doctorId, Long timeSlotId) {
        if(Objects.isNull(doctorId) || Objects.isNull(timeSlotId)) {
            throw new DoctorException("Doctor id or time slot id invalid");
        }
        List<Appointment> appointments = doctorRepository.getDoctorsAppointmentsByTimeSlotId(doctorId, timeSlotId);
        if (appointments.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved appointments of doctor with id: {} and time slot id: {}", doctorId, timeSlotId);
        return appointments;
    }

    /**
     * This method is used to get all doctors by department.
     * @param departmentName the department of the doctor.
     * doesn't get involved in the transaction.
     * @return all doctors with the given department.
     */

    @Transactional(readOnly = true)
    public List<Doctor> getDoctorsByDepartment(String departmentName) {
        if (Objects.isNull(departmentName) || departmentName.isEmpty()) {
            throw new DoctorException("Department invalid");
        }
        List<Doctor> doctors = doctorRepository.getDoctorsByDepartment(departmentName);
        if (doctors.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved doctors with department: {}", departmentName);
        return doctors;
    }

    // set days doctor is available
    @Transactional
    public void setDoctorAvailability(long doctorId, Doctor.DaysOfTheWeek day, Set<TimeSlot> timeSlots) {
        if (Objects.isNull(day) || Objects.isNull(timeSlots)) {
            throw new DoctorException("Day or time slots cannot be null");
        }
        if (timeSlots.isEmpty()) {
            throw new DoctorException("Time slots cannot be empty");
        }

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorException("Doctor with id: " + doctorId + " not found"));

        validateTimeSlots(timeSlots);

        Set<TimeSlot> mergedTimeSlots = mergeTimeSlots(timeSlots);
        doctor.getAvailableDates().put(day, mergedTimeSlots);
        doctorRepository.save(doctor);

        log.info("Doctor with id: {}, Day: {} availability set", doctorId, day);
    }

    private void validateTimeSlots(Set<TimeSlot> timeSlots) {
        for (TimeSlot timeSlot : timeSlots) {
            if (timeSlot.getStartTime().isAfter(timeSlot.getEndTime())) {
                throw new TimeSlotException("Invalid time slot: Start time must be before end time");
            }
        }
    }

    private Set<TimeSlot> mergeTimeSlots(Set<TimeSlot> timeSlots) {
        List<TimeSlot> sortedTimeSlots = new ArrayList<>(timeSlots);
        sortedTimeSlots.sort(Comparator.comparing(TimeSlot::getStartTime));

        LinkedList<TimeSlot> merged = new LinkedList<>();
        for (TimeSlot timeSlot : sortedTimeSlots) {
            if (merged.isEmpty() || merged.getLast().getEndTime().isBefore(timeSlot.getStartTime())) {
                merged.add(timeSlot);
            } else {
                merged.getLast().setEndTime(
                        timeSlot.getEndTime().isAfter(merged.getLast().getEndTime())
                                ? timeSlot.getEndTime()
                                : merged.getLast().getEndTime()
                );
            }
        }
        return new HashSet<>(merged);
    }


    @Transactional
    public void removeDoctorAvailability(long id, Doctor.DaysOfTheWeek day){
        // Check if doctor exists
        Doctor doctor =
                doctorRepository.findById(id).orElseThrow(()
                        -> new DoctorException("Doctor with id: " + id + " not found"));
        Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> availableDates = doctor.getAvailableDates();
        availableDates.remove(day);
        doctor.setAvailableDates(availableDates);
        doctorRepository.save(doctor);
        log.info("Doctor with id: {}, Day: {} availability removed", id, day);

    }

    @Transactional(readOnly = true)
    public Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> getDoctorAvailability(long id) {
        if(Objects.isNull(id)) {
            throw new DoctorException("Invalid ID ...");
        }
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()
                -> new DoctorException("Doctor with id: " + id + " not found"));
        Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> availableDates = doctor.getAvailableDates();
        log.info("Doctor with id: {} availability retrieved", id);

        return availableDates;
    }







}
