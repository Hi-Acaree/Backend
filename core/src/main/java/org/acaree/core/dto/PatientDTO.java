package org.acaree.core.dto;

import lombok.Getter;
import lombok.Setter;
import org.acaree.core.model.Patient;
import org.acaree.core.model.Person;

@Getter @Setter
public class PatientDTO {
    private long id;
    private PersonDTO patientDetails;

    public static PatientDTO from(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        //  Patient has a reference to Person
        PersonDTO personDTO = PersonDTO.from(patient.getPersonDetails());
        dto.setPatientDetails(personDTO);
        // additional patient-specific fields
        return dto;
    }



}
