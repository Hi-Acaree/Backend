package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.repository.PatientRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PatientCleanupService {

    private final PatientRepository patientRepository;

    // Constructor injection of the repository
    public PatientCleanupService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 60000) // Run every minute
    public void cleanupExpiredPatients() {

        // Implementation to find and delete expired patient records
        patientRepository.deleteAllByExpiryBefore(LocalDateTime.now());
        log.info("Expired temporary patient records cleaned up");
    }
}
