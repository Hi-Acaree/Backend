package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.DoctorException;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.DoctorAvailability;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.DoctorAvailabilityRepository;
import org.acaree.core.repository.DoctorRepository;
import org.acaree.core.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;

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
    private final DoctorAvailabilityRepository doctorAvailabilityRepository;

    //== constructor ==

    /**
     * Constructor for DoctorService.
     * @param doctorRepository the doctor repository to be injected.
     * @param doctorAvailabilityRepository the doctor availability repository to be injected.
     */
    @Autowired
    public DoctorService(DoctorRepository doctorRepository,
   DoctorAvailabilityRepository doctorAvailabilityRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorAvailabilityRepository = doctorAvailabilityRepository;
    }


    /**
     * This method is used to save a doctor to the database.
     * @param doctor the doctor to be saved.
     * {@code @Transactional} annotation to indicate that this method is transactional.
     * @throws DoctorException if doctor object is null.
     * @return the saved doctor.
     */

    @Transactional
    public Doctor saveDoctor(Doctor doctor) throws DoctorException{
           if (Objects.isNull(doctor)) {
                throw new DoctorException("Doctor object cannot be null", ErrorType.DOCTOR_INVALID_INPUT);
            }
           Doctor savedDoctor = doctorRepository.save(doctor);
              log.info("Saved doctor with id: {}", savedDoctor.getId());
                return savedDoctor;
    }

    /**
     * This method is used to get a doctor by id.
     * @param id the id of the doctor.
     * @throws DoctorException if doctor with id is not found.
     * {@code @Optional<Doctor>} is a container object which may or may not contain a non-null value.
     * @return the doctor with the given id.
     */

    @Transactional(readOnly = true)
    public Optional<Doctor> getDoctorById(long id) throws DoctorException {
        if (id < 0) {
            throw new DoctorException("Invalid doctor input", ErrorType.DOCTOR_INVALID_INPUT);
        }
        Doctor doctor = getDoctor(id).orElseThrow(()
                -> new DoctorException("Doctor with id: " + id + " not found", ErrorType.DOCTOR_NOT_FOUND));
        log.info("Doctor with id: {} found", id);

        return Optional.of(doctor);
    }

    /**
     * This method is used to delete a doctor by id.
     * @param id the id of the doctor.
     * @throws DoctorException if doctor with id is not found or if doctor has appointments.
     */
    @Transactional
    public void deleteDoctorById(long id) throws DoctorException {
        // Check if doctor exists
        Doctor doctor =
                getDoctor(id).orElseThrow(()
                        -> new DoctorException("Doctor with id: " + id + " not found", ErrorType.DOCTOR_NOT_FOUND));

        // Check if doctor has appointments

        if (doctor.getAppointments() != null && !doctor.getAppointments().isEmpty()) {
            throw new DoctorException("Doctor with id: " + id + " has appointments", ErrorType.DOCTOR_HAS_APPOINTMENTS);
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
    public Doctor updateDoctor(Doctor doctor) throws DoctorException {
        if (Objects.isNull(doctor)) {
            throw new DoctorException("Doctor object cannot be null", ErrorType.DOCTOR_INVALID_INPUT);
        }
        // Check if doctor exists
        getDoctor(doctor.getId()).orElseThrow(()
                -> new DoctorException("Doctor with id: " + doctor.getId() + " not found", ErrorType.DOCTOR_NOT_FOUND));
        long id = doctor.getId();
        log.info("Doctor with id: {} updated", id);

        // Update doctor
        return doctorRepository.save(doctor);
    }

    //== get all doctors ==

    /**
     * This method is used to get all doctors.
     * @return all doctors.
     */

    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }

    /**
     * This method is used to get all appointments of a doctor.
     * @param doctorId the id of the doctor.
     * @throws DoctorException if doctor id is null.
     * @return all appointments of the doctor with the given id.
     */

    @Transactional(readOnly = true)
    public List<Appointment> getDoctorsAppointments(Long doctorId) throws DoctorException {
        if(Objects.isNull(doctorId)) {
            throw new DoctorException("Doctor id cannot be null", ErrorType.DOCTOR_INVALID_INPUT);
        }
        List<Appointment> appointments = doctorRepository.getDoctorsAppointments(doctorId);
        if (appointments.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved appointments of doctor with id: {}", doctorId);
        return appointments;

    }
    // == get doctors by specialization ==
    /**
     * This method is used to get all doctors by specialization.
     * @param specialization the specialization of the doctor.
     * @throws DoctorException if specialization is null.
     * @return all doctors with the given specialization.
     */

    @Transactional(readOnly = true)
    public List<Doctor> getDoctorsBySpecialization(String specialization) throws DoctorException {
        if (Objects.isNull(specialization)) {
            throw new DoctorException("Specialization cannot be null", ErrorType.DOCTOR_INVALID_INPUT);
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
     * @return all appointments of the doctor with the given patient id.
     */

    @Transactional(readOnly = true)
    public List<Appointment> getDoctorsAppointmentsByPatientId(Long doctorId, Long patientId) throws DoctorException {
        if(Objects.isNull(doctorId) || Objects.isNull(patientId)) {
            throw new DoctorException("Doctor id or patient id cannot be null", ErrorType.DOCTOR_INVALID_INPUT);
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
     * @return all appointments of the doctor with the given patient id and time slot id.
     */

    @Transactional(readOnly = true)
    public List<Appointment> getDoctorsAppointmentsByPatientIdAndTimeSlotId(Long doctorId, Long patientId, Long timeSlotId)
            throws DoctorException{
        if(Objects.isNull(doctorId) || Objects.isNull(patientId) || Objects.isNull(timeSlotId)) {
            throw new DoctorException("Doctor id or patient id or time slot id invalid", ErrorType.DOCTOR_INVALID_INPUT);
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
    public List<Appointment> getDoctorsAppointmentsByTimeSlotId(Long doctorId, Long timeSlotId)
            throws DoctorException{
        if(Objects.isNull(doctorId) || Objects.isNull(timeSlotId)) {
            throw new DoctorException("Doctor id or time slot id invalid", ErrorType.DOCTOR_INVALID_INPUT);
        }
        List<Appointment> appointments = doctorRepository.getDoctorsAppointmentsByTimeSlotId(doctorId, timeSlotId);
        if (appointments.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved appointments of doctor with id: {} and time slot id: {}", doctorId, timeSlotId);
        return appointments;
    }

        //== get doctors by department ==

    /**
     * This method is used to get all doctors by department.
     * @param departmentName
     * @return list of all doctors with the given department.
     * @throws DoctorException
     */

    @Transactional(readOnly = true)
    public List<Doctor> getDoctorsByDepartment(String departmentName)
            throws DoctorException{
        if (Objects.isNull(departmentName) || departmentName.isEmpty()) {
            throw new DoctorException("Department invalid", ErrorType.DOCTOR_INVALID_INPUT);
        }
        List<Doctor> doctors = doctorRepository.getDoctorsByDepartment(departmentName);
        if (doctors.isEmpty()) {
            return Collections.emptyList();
        }
        log.info("Retrieved doctors with department: {}", departmentName);
        return doctors;
    }

    /**
     * This method is used to set the availability of a doctor.
     * @param doctorId the id of the doctor.
     * @param day the day of the week.
     * @param timeSlots the time slots of the doctor.
     * @throws DoctorException
     * @throws TimeSlotException
     */

        //== set days doctor is available ==
    @Transactional
    public void setDoctorAvailability(long doctorId, Doctor.DaysOfTheWeek day, Set<TimeSlot> timeSlots)
            throws DoctorException, TimeSlotException {
        if (Objects.isNull(day) || Objects.isNull(timeSlots)) {
            throw new DoctorException("Day or time slots cannot be null", ErrorType.DOCTOR_INVALID_INPUT);
        }
        if (timeSlots.isEmpty()) {
            throw new DoctorException("Time slots cannot be empty", ErrorType.DOCTOR_INVALID_INPUT);
        }

        Doctor doctor = getDoctor(doctorId).orElseThrow(()
                -> new DoctorException("Doctor with id: " + doctorId + " not found", ErrorType.DOCTOR_NOT_FOUND));

        validateTimeSlots(timeSlots);

        List<TimeSlot> mergedTimeSlots = mergeTimeSlots(timeSlots);
        Set<DoctorAvailability> availabilities = doctor.getDaysAvailable();

        for (TimeSlot timeSlot : mergedTimeSlots) {
            DoctorAvailability availability = new DoctorAvailability();
            availability.setDoctor(doctor);
            availability.setDayOfWeek(day);
            availability.setTimeSlots(new HashSet<>(Collections.singletonList(timeSlot)));
            // validate time slots
            doctorAvailabilityRepository.save(availability);
            availabilities.add(availability);
        }

        doctor.setDaysAvailable(availabilities);
        doctorRepository.save(doctor);

        log.info("Doctor with id: {}, Day: {} availability set", doctorId, day);

    }



    /**
     * This method is used to remove the doctor availability.
     * @param id the id of the doctor.
     * @param day the day of the week.
     * @throws DoctorException
     */


    //== remove doctor availability

    @Transactional
    public void removeDoctorAvailability(long id, Doctor.DaysOfTheWeek day) throws DoctorException {
        if (id < 0) {
            throw new DoctorException("Invalid doctor input", ErrorType.DOCTOR_INVALID_INPUT);
        }
        if (Objects.isNull(day)) {
            throw new DoctorException("Day cannot be null", ErrorType.DOCTOR_INVALID_INPUT);
        }

        Doctor doctor = getDoctor(id).orElseThrow(() -> new DoctorException("Doctor with id: " + id + " not found",
                ErrorType.DOCTOR_NOT_FOUND));
        Set<DoctorAvailability> availabilities = doctor.getDaysAvailable().stream()
                .filter(availability -> availability.getDayOfWeek().equals(day))
                .collect(Collectors.toSet());

        if (availabilities.isEmpty()) {
            throw new DoctorException("Doctor with id: " + id + " has no availability on day: " + day,
                    ErrorType.DOCTOR_NOT_AVAILABLE);
        }

        // Remove all DoctorAvailability entries for the specific day
        doctorAvailabilityRepository.deleteAll(availabilities); // Assuming this method exists in your repository
        doctor.getDaysAvailable().remove(day);

        doctorRepository
                .save(doctor);
    }

    /**
     * This method is used to update the doctor weekly schedule.
     * @param id the id of the doctor.
     * @param weeklySchedule the weekly schedule of the doctor.
     * @throws DoctorException
     * @throws TimeSlotException
     */
    @Transactional
    public void updateDoctorWeeklySchedule(long id, Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> weeklySchedule)
            throws DoctorException, TimeSlotException {
        if (id < 0) {
            throw new DoctorException("Invalid doctor input", ErrorType.DOCTOR_INVALID_INPUT);
        }
        if (Objects.isNull(weeklySchedule)) {
            throw new DoctorException("Invalid weekly schedule input", ErrorType.DOCTOR_INVALID_INPUT);
        }

        Doctor doctor = getDoctor(id).orElseThrow(() -> new DoctorException("Doctor with id: " + id + " not found",
                ErrorType.DOCTOR_NOT_FOUND));

        for (Map.Entry<Doctor.DaysOfTheWeek, Set<TimeSlot>> entry : weeklySchedule.entrySet()) {
            Doctor.DaysOfTheWeek day = entry.getKey();
            Set<TimeSlot> timeSlots = entry.getValue();

            if (Objects.isNull(day) || Objects.isNull(timeSlots)) {
                throw new DoctorException("Invalid day or time slots, please check your input",
                        ErrorType.DOCTOR_INVALID_INPUT);
            }
            if (timeSlots.isEmpty()) {
                throw new DoctorException("Time slots cannot be empty",
                        ErrorType.DOCTOR_INVALID_INPUT);
            }

            validateTimeSlots(timeSlots);
            Set<DoctorAvailability> availabilities = new HashSet<>();
            List<TimeSlot> mergedTimeSlots = mergeTimeSlots(timeSlots);

            for (TimeSlot timeSlot : mergedTimeSlots) {
                DoctorAvailability availability = new DoctorAvailability();
                availability.setDoctor(doctor);
                availability.setDayOfWeek(day);
                availability.setTimeSlots(new HashSet<>(Collections.singletonList(timeSlot)));
                availabilities.add(availability);
                // Save or
                // Update DoctorAvailability
                doctorAvailabilityRepository.save(availability);
                doctor.getDaysAvailable().add(availability);
            }


        }
        doctorRepository.save(doctor);
    }

    /**
     * This method is used to get the doctor availability.
     * @param id the id of the doctor.
     * @return the doctor availability.
     * @throws DoctorException
     */
    @Transactional(readOnly = true)
    public Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> getDoctorAvailability(long id) {
        if (id < 0) {
            throw new DoctorException("Invalid doctor input", ErrorType.DOCTOR_INVALID_INPUT);
        }

        Doctor doctor = getDoctor(id).orElseThrow(() -> new DoctorException("Doctor with id: " + id + " not found",
                ErrorType.DOCTOR_NOT_FOUND));
        Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> availableDates = new HashMap<>();

        for (DoctorAvailability availability : doctor.getDaysAvailable()) {
            availableDates.put(availability.getDayOfWeek(), availability.getTimeSlots());
        }

        log.info("Doctor with id: {} availability retrieved", id);
        return availableDates;
    }




    //== private methods ==

    /**
     * This method is used to get the doctor.
     * @param id the id of the doctor.
     * @throws DoctorException
     * @return the doctor with the given id.
     */

    private Optional<Doctor> getDoctor(long id) throws DoctorException{
        if (id < 0) {
            throw new DoctorException("Invalid doctor input",
                    ErrorType.DOCTOR_INVALID_INPUT);
        }
        // Check if doctor exists
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()
                -> new DoctorException("Doctor with id: " + id + " not found",
                ErrorType.DOCTOR_NOT_FOUND));
        return Optional.of(doctor);
    }

    /**
     * This method is used to validate time slots.
     * @param timeSlots the time slots to be validated.
     * @throws TimeSlotException if start time is after end time.
     */
    private void validateTimeSlots(Set<TimeSlot> timeSlots)
            throws TimeSlotException{
        for (TimeSlot timeSlot : timeSlots) {
            if (timeSlot.getStartTime().isAfter(timeSlot.getEndTime())) {
                throw new TimeSlotException("Invalid time slot: Start time must be before end time");
            }}}

    /**
     * This method is used to get the merge time slots.
     * @param timeSlots the time slots to be merged.
     * @return list of merged time slots.
     */

    //== merge time slots ==

    /**
     * This method is used to merge time slots.
     * @param timeSlots the set of time slots to be merged.
     * @return list of merged time slots.
     */

    private List<TimeSlot> mergeTimeSlots(Set<TimeSlot> timeSlots) {
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
        return merged;
    }



}
