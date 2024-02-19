package org.acaree.core.dto;

import lombok.Getter;
import lombok.Setter;
import org.acaree.core.exceptions.DoctorException;
import org.acaree.core.model.Doctor;
import org.acaree.core.util.ErrorType;

import java.util.Objects;

@Getter @Setter
public class DoctorDTO {
    private Long id;
    private PersonDTO personDetails;
    private String specialization;
    private String hospitalName;
    private String departmentName;

    public static DoctorDTO from(Doctor doctor) {
        Objects.requireNonNull(doctor, "Doctor cannot be null");

        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());

        //PersonDTO.from() handles null checks internally
        dto.setPersonDetails(PersonDTO.from(doctor.getPersonDetails()));

        // Ensure required fields are not null or empty
        if (doctor.getSpecialization() == null || doctor.getSpecialization().isEmpty()) {
            throw new DoctorException("Doctor specialization is required", ErrorType.DOCTOR_INVALID_INPUT);
        }
        if (doctor.getHospitalName() == null || doctor.getHospitalName().isEmpty()) {
            throw new DoctorException("Doctor hospital name is required", ErrorType.DOCTOR_INVALID_INPUT);
        }
        if (doctor.getDepartmentName() == null || doctor.getDepartmentName().isEmpty()) {
            throw new DoctorException("Doctor department name is required", ErrorType.DOCTOR_INVALID_INPUT);
        }

        dto.setSpecialization(doctor.getSpecialization());
        dto.setHospitalName(doctor.getHospitalName());
        dto.setDepartmentName(doctor.getDepartmentName());

        return dto;
    }

}
