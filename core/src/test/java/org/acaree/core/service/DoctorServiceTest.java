package org.acaree.core.service;

import org.acaree.core.exceptions.DoctorException;
import org.acaree.core.model.*;
import org.acaree.core.repository.DoctorAvailabilityRepository;
import org.acaree.core.repository.DoctorRepository;
import org.acaree.core.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static org.hibernate.validator.internal.util.Contracts.assertNotEmpty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This class is a service class for Doctor.
 * <p> This class is used to perform CRUD operations on the Doctor class.
 * </p>
 */

@ExtendWith(MockitoExtension.class)
 class DoctorServiceTest {
    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private PersonRepository personRepository;

    @Mock
    private DoctorAvailabilityRepository doctorAvailabilityRepository;
    @InjectMocks
    private DoctorService doctorService;

    private Doctor doctor;
    private Appointment appointment;
    private Patient patient;
    private TimeSlot timeSlot;
    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;
    private Doctor doctor1;
    private Doctor doctor2;
    private List<Appointment> appointments = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private Set<TimeSlot> timeSlots;
    private Doctor.DaysOfTheWeek day;
    private Doctor.DaysOfTheWeek[] daysOfTheWeeks;
    private Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> availability;
    private Set<TimeSlot> timeSlots1;

    @BeforeEach
    void setUp() {
        daysOfTheWeeks = new Doctor.DaysOfTheWeek[]{Doctor.DaysOfTheWeek.MONDAY,
                Doctor.DaysOfTheWeek.TUESDAY, Doctor.DaysOfTheWeek.WEDNESDAY, Doctor.DaysOfTheWeek.THURSDAY,
                Doctor.DaysOfTheWeek.FRIDAY, Doctor.DaysOfTheWeek.SATURDAY, Doctor.DaysOfTheWeek.SUNDAY};
        timeSlots1 = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            timeSlots1.add(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(10)));
        }
        availability = new HashMap<>();
        for (Doctor.DaysOfTheWeek day : daysOfTheWeeks) {
            availability.put(day, timeSlots1);
        }

        person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");

        person1 = new Person();
        person1.setId(2L);
        person1.setFirstName("Jane");
        person1.setLastName("Doe");

        person2 = new Person();
        person2.setId(3L);
        person2.setFirstName("Jack");
        person2.setLastName("Doe");

        person3 = new Person();
        person3.setId(4L);
        person3.setFirstName("Jill");
        person3.setLastName("Doe");


        timeSlot = new TimeSlot();
        timeSlot.setId(1L);
        timeSlot.setStartTime(LocalDateTime.now());
        timeSlot.setEndTime(LocalDateTime.now().plusMinutes(10));

        doctor = new Doctor();
        doctor1 = new Doctor();
        doctor2 = new Doctor();
        patient = new Patient();

        // first doctor with appointments
        doctor.setSpecialization("Cardiologist");
        doctor.setHospitalName("Apollo");
        doctor.setDepartmentName("Cardiology");
        doctor.setPersonDetails(person);
        doctor.setId(1L);

        // second doctor without appointments
        doctor1.setSpecialization("Dentist");
        doctor1.setHospitalName("Apollo");
        doctor1.setDepartmentName("Dentistry");
        doctor1.setPersonDetails(person2);
        doctor1.setId(3L);

        // third doctor without appointments
        doctor2.setSpecialization("Dentist");
        doctor2.setHospitalName("Apollo");
        doctor2.setDepartmentName("Dentistry");
        doctor2.setPersonDetails(person3);
        doctor2.setId(4L);


        patient.setPersonDetails(person1);
        patient.setId(2L);


        appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot);
        appointment.setReason("Checkup");
        appointment.setBooked(true);

        appointments.add(appointment);
        doctors.add(doctor1);
        doctors.add(doctor2);

        doctor.setAppointments(appointments);





    }

    @Test
    void test_Save_Doctor_Success() {
        when(doctorRepository.save(any(Doctor.class))).thenAnswer(i -> i.getArguments()[0]);

        Doctor savedDoctor = doctorService.saveDoctor(doctor);


        assertNotNull(savedDoctor);
        assertEquals(doctor.getId(), savedDoctor.getId());
    }

    @Test
    void test_SaveDoctor_Failure() {
        when(doctorRepository.save(any(Doctor.class))).thenThrow(DoctorException.class);

        assertThrows(DoctorException.class, () -> doctorService.saveDoctor(doctor));

    }

    @Test
    void getDoctor_By_Id_Success() {
        // Arrange
        when(doctorRepository.findById(1L)).thenReturn(Optional.ofNullable(doctor));

        // Act

        Optional<Doctor> doctorOptional = doctorService.getDoctorById(1L);

        // Assert

        assertNotNull(doctorOptional);
        assertEquals(doctor.getId(), doctorOptional.map(Doctor::getId).orElse(null));
        assertEquals(doctor.getSpecialization(), doctorOptional.map(Doctor::getSpecialization).orElse(null));
        assertEquals(doctor.getHospitalName(), doctorOptional.map(Doctor::getHospitalName).orElse(null));

    }

    @Test
    void test_Get_DoctorBy_Id_Failure() {
        when(doctorRepository.findById(1L)).thenThrow(DoctorException.class);

        assertThrows(DoctorException.class, () -> doctorService.getDoctorById(1L));
    }


    @Test
    void test_Update_Doctor() {
        // Arrange
        when(doctorRepository.findById(1L)).thenReturn(Optional.ofNullable(doctor));
        when(doctorRepository.save(any(Doctor.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        Doctor updatedDoctor = doctorService.updateDoctor(doctor);

        // Assert
        assertNotNull(updatedDoctor);
        assertEquals(doctor.getId(), updatedDoctor.getId());
        assertEquals(doctor.getSpecialization(), updatedDoctor.getSpecialization());
        assertEquals(doctor.getHospitalName(), updatedDoctor.getHospitalName());
    }

    @Test
    void testUpdate_Doctor_Failure() {
        // Arrange
        when(doctorRepository.findById(1L)).thenThrow(DoctorException.class);

        // Act and Assert
        assertThrows(DoctorException.class, () -> doctorService.updateDoctor(doctor));
    }

    @Test
    void testDeleteDoctor_By_Id_With_No_Appointment_Success() {
        // Arrange
        when(doctorRepository.findById(3L)).thenReturn(Optional.ofNullable(doctor1));

        // Act
        doctorService.deleteDoctorById(3L);

        // Assert
        // No exception thrown
        assertEquals(1L, doctor.getId());
        assertEquals("Cardiologist", doctor.getSpecialization());
        assertEquals("Apollo", doctor.getHospitalName());
        assertEquals("Cardiology", doctor.getDepartmentName());
    }

    @Test
    void test_Delete_Doctor_By_Id_With_Appointment_Failure() {
        // Arrange
        when(doctorRepository.findById(1L)).thenThrow(DoctorException.DoctorHasAppointmentsException.class);

        // Act and Assert
        assertThrows(DoctorException.DoctorHasAppointmentsException.class, () -> doctorService.deleteDoctorById(1L));
    }

    @Test
    void test_Delete_Doctor_By_Id__Invalid_Id_Failure() {
        // Arrange
        when(doctorRepository.findById(5L)).thenThrow(DoctorException.class);

        // Act and Assert
        assertThrows(DoctorException.class, () -> doctorService.deleteDoctorById(5L));
    }

    @Test
    void test_Get_All_Iterable_DoctorsSuccess() {
        // Arrange
        when(doctorRepository.findAll()).thenReturn(singletonList(doctor));

        // Act
        Iterable<Doctor> doctors = doctorService.getAllDoctors();

        // Assert
        assertNotNull(doctors);
        assertEquals(1, singletonList(doctor).size());
        assertEquals(1L, doctor.getId());
        assertEquals("Cardiologist", doctor.getSpecialization());
        assertEquals("Apollo", doctor.getHospitalName());
        assertEquals("Cardiology", doctor.getDepartmentName());
    }

    @Test
    void test_Get_All_Doctor_Appointments_Success() {

        // Arrange
        when(doctorRepository.getDoctorsAppointments(1L)).thenReturn(appointments);

        // Act
        List<Appointment> doctorsAppointments = doctorService.getDoctorsAppointments(1L);

        // Assert
        assertEquals(1, doctorsAppointments.size());
        assertEquals(1L, doctorsAppointments.get(0).getId());
        assertEquals("Checkup", doctorsAppointments.get(0).getReason());
        assertEquals(true, doctorsAppointments.get(0).isBooked());
        assertEquals(1L, doctorsAppointments.get(0).getDoctor().getId());
        assertEquals(2L, doctorsAppointments.get(0).getPatient().getId());
        assertEquals(1L, doctorsAppointments.get(0).getTimeSlot().getId());


    }

    @Test
    void test_Get_All_Doctor_Appointments_By_Patient_Id_Success() {

        // Arrange
        when(doctorRepository.getDoctorsAppointmentsByPatientId(1L, 2L)).thenReturn(appointments);

        // Act
        List<Appointment> doctorsAppointments = doctorService.getDoctorsAppointmentsByPatientId(1L, 2L);

        // Assert
        assertEquals(1, doctorsAppointments.size());
        assertEquals(1L, doctorsAppointments.get(0).getId());
        assertEquals("Checkup", doctorsAppointments.get(0).getReason());
        assertEquals(true, doctorsAppointments.get(0).isBooked());
        assertEquals(1L, doctorsAppointments.get(0).getDoctor().getId());
        assertEquals(2L, doctorsAppointments.get(0).getPatient().getId());
        assertEquals(1L, doctorsAppointments.get(0).getTimeSlot().getId());
    }

    @Test
    void test_Get_All_Doctor_Appointments_By_Patient_Id_And_Time_Slot_Id_Success() {

        // Arrange
        when(doctorRepository.getDoctorsAppointmentsByPatientIdAndTimeSlotId(1L, 2L, 1L)).thenReturn(appointments);

        // Act
        List<Appointment> doctorsAppointments = doctorService.getDoctorsAppointmentsByPatientIdAndTimeSlotId(1L, 2L, 1L);

        // Assert
        assertEquals(1, doctorsAppointments.size());
        assertEquals(1L, doctorsAppointments.get(0).getId());
        assertEquals("Checkup", doctorsAppointments.get(0).getReason());
        assertEquals(true, doctorsAppointments.get(0).isBooked());
        assertEquals(1L, doctorsAppointments.get(0).getDoctor().getId());
        assertEquals(2L, doctorsAppointments.get(0).getPatient().getId());
        assertEquals(1L, doctorsAppointments.get(0).getTimeSlot().getId());
    }

    @Test
    void test_Get_All_Doctor_Appointments_By_Time_Slot_Id_Success() {

        // Arrange
        when(doctorRepository.getDoctorsAppointmentsByTimeSlotId(1L, 1L)).thenReturn(appointments);

        // Act
        List<Appointment> doctorsAppointments = doctorService.getDoctorsAppointmentsByTimeSlotId(1L, 1L);

        // Assert
        assertEquals(1, doctorsAppointments.size());
        assertEquals(1L, doctorsAppointments.get(0).getId());
        assertEquals("Checkup", doctorsAppointments.get(0).getReason());
        assertEquals(true, doctorsAppointments.get(0).isBooked());
        assertEquals(1L, doctorsAppointments.get(0).getDoctor().getId());
        assertEquals(2L, doctorsAppointments.get(0).getPatient().getId());
        assertEquals(1L, doctorsAppointments.get(0).getTimeSlot().getId());
    }

    @Test
    void test_Get_All_Doctors_By_Specialization_Success() {

        // Arrange
        when(doctorRepository.getDoctorsBySpecialization("Dentist")).thenReturn(doctors);

        // Act
        List<Doctor> doctors = doctorService.getDoctorsBySpecialization("Dentist");

        // Assert
        assertEquals(2, doctors.size());
        assertEquals(3L, doctors.get(0).getId());
        assertEquals(4L, doctors.get(1).getId());
        assertEquals("Dentist", doctors.get(0).getSpecialization());
        assertEquals("Apollo", doctors.get(0).getHospitalName());
        assertEquals("Dentistry", doctors.get(0).getDepartmentName());
    }

    @Test
    void test_Get_All_Doctors_By_Specialization_Failure() {

        // Arrange
        when(doctorRepository.getDoctorsBySpecialization("Surgeon")).thenThrow(DoctorException.class);

        // Act and Assert
        assertThrows(DoctorException.class, () -> doctorService.getDoctorsBySpecialization("Surgeon"));
    }


    @Test
    void test_Get_All_Doctors_By_Department_Success() {

        // Arrange
        when(doctorRepository.getDoctorsByDepartment("Dentistry")).thenReturn(doctors);

        // Act
        List<Doctor> doctors = doctorService.getDoctorsByDepartment("Dentistry");

        // Assert
        assertEquals(2, doctors.size());
        assertEquals(3L, doctors.get(0).getId());
        assertEquals(4L, doctors.get(1).getId());
        assertEquals("Dentist", doctors.get(0).getSpecialization());
        assertEquals("Apollo", doctors.get(0).getHospitalName());
        assertEquals("Dentistry", doctors.get(0).getDepartmentName());
    }

    @Test
    void test_Get_All_Doctors_By_Department_Failure() {

        // Arrange
        when(doctorRepository.getDoctorsByDepartment("Radiology")).thenThrow(DoctorException.class);

        // Act and Assert
        assertThrows(DoctorException.class, () -> doctorService.getDoctorsByDepartment("Radiology"));
    }

    @Test
    void test_Set_Doctor_Availability_Success() {
        // Arrange
        Doctor.DaysOfTheWeek day = Doctor.DaysOfTheWeek.MONDAY;
        Set<TimeSlot> timeSlots = new HashSet<>();
        timeSlots.add(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(10)));

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));
        when(doctorAvailabilityRepository.save(any(DoctorAvailability.class))).thenAnswer(i -> i.getArguments()[0]);
        when(doctorRepository.save(any(Doctor.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        doctorService.setDoctorAvailability(1L, day, timeSlots);

        // Assert
        assertNotNull(doctor.getDaysAvailable());
        assertTrue(doctor.getDaysAvailable().contains(new DoctorAvailability(doctor, day, timeSlots)));
        verify(doctorRepository).save(doctor);
    }

    @Test
    void test_Set_Doctor_Availability_Failure() {
        // Arrange
        Doctor.DaysOfTheWeek day = Doctor.DaysOfTheWeek.MONDAY;
        Set<TimeSlot> timeSlots = new HashSet<>();
        timeSlots.add(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(10)));

        when(doctorRepository.findById(1L)).thenThrow(DoctorException.class);

        // Act and Assert
        assertThrows(DoctorException.class, () -> doctorService.setDoctorAvailability(1L, day, timeSlots));
    }

@Test
void testRemoveDoctorAvailability_Success() {
    // Arrange
    long doctorId = 1L;
    Doctor.DaysOfTheWeek day = Doctor.DaysOfTheWeek.MONDAY;
    Doctor doctor = new Doctor();
    Set<TimeSlot> timeSlots = new HashSet<>();
    timeSlots.add(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(10)));
    doctor.getDaysAvailable().add(new DoctorAvailability(doctor, day, timeSlots));

    when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
    doNothing().when(doctorAvailabilityRepository).deleteAll(any(Set.class));

    // Act
    doctorService.removeDoctorAvailability(doctorId, day);

    // Assert
verify(doctorRepository).findById(doctorId);
verify(doctorAvailabilityRepository).deleteAll(any(Set.class));

}

    @Test
    void testGetDoctorAvailability_Success() {
        // Arrange
        long doctorId = 1L;
        Doctor doctor = createMockDoctor();
        Doctor.DaysOfTheWeek day = Doctor.DaysOfTheWeek.MONDAY;

        doctor.getDaysAvailable().add(new DoctorAvailability(doctor, day, new HashSet<>(
                Arrays.asList(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(10))))
        ));
        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));

        // Act
        Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> availability = doctorService.getDoctorAvailability(doctorId);

        // Assert
        verify(doctorRepository).findById(doctorId);
        assertEquals(1, availability.size());
        assertEquals(1, availability.get(day).size());
        assertEquals(doctor.getDaysAvailable().iterator().next().getTimeSlots(), availability.get(day));

    }

    @Test
    void testUpdateDoctorWeeklySchedule() {
    // Arrange
    long doctorId = 1L;
    Doctor doctor = createMockDoctor();
    doctor.setPersonDetails(person);
    Doctor.DaysOfTheWeek day = Doctor.DaysOfTheWeek.MONDAY;
    Set<TimeSlot> timeSlots = new HashSet<>(
            Arrays.asList(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(30)))
    );

    Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> newAvailability = new HashMap<>();
    newAvailability.put(day, timeSlots);

    DoctorAvailability doctorAvailability = new DoctorAvailability(doctor, day, timeSlots);

    doctor.getDaysAvailable().add(doctorAvailability);
    when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
    when(doctorRepository.save(any(Doctor.class))).thenAnswer(i -> i.getArguments()[0]);

    // Act
    doctorService.updateDoctorWeeklySchedule(doctorId, newAvailability);

    // Assert
    verify(doctorRepository).findById(doctorId);
    assertEquals(1, newAvailability.size());
    assertEquals(1, newAvailability.get(day).size());
    assertEquals(doctor.getDaysAvailable().iterator().next().getTimeSlots(), newAvailability.get(day));
}

    private Doctor createMockDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDaysAvailable(new HashSet<>());
        return doctor;
    }

}




