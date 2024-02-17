package org.acaree.core.service;

import org.acaree.core.model.Doctor;
import org.acaree.core.model.DoctorAvailability;
import org.acaree.core.repository.DoctorAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for DoctorAvailability entity
 * <p> This class is responsible for all the business logic related to DoctorAvailability entity</p>
 * {@code @Service} annotation to mark the class as a service class
 * {@code @Autowired} annotation to inject the DoctorAvailabilityRepository
 */

@Service
public class DoctorAvailabilityService {

    private final DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Autowired
    public DoctorAvailabilityService(DoctorAvailabilityRepository doctorAvailabilityRepository) {
        this.doctorAvailabilityRepository = doctorAvailabilityRepository;
    }

    /**
     * This method is used to find a doctor availability by its ID and day availability
     * @param day
     * @param doctorId
     * @return An optional of DoctorAvailability object
     */

    Optional<DoctorAvailability> findDoctorAvailabilityByDayAndDoctorId(Doctor.DaysOfTheWeek day, Long doctorId) {
        // fetch the doctor availability for the given day and doctor id
        return doctorAvailabilityRepository.findByDayAndDoctorId(day, doctorId);
    }


}
