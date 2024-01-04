package org.acaree.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Entity
@Slf4j
@Getter @Setter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Person personDetails;

    Map<String, String> medicalHistory;

    public Patient(Person personDetails, Map<String, String> medicalHistory) {
        this.personDetails = personDetails;
        this.medicalHistory = medicalHistory;
    }





}
