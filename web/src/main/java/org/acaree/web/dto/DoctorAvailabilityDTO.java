package org.acaree.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.TimeSlot;

import java.util.Map;
import java.util.Set;

@Slf4j
@Getter @Setter
@NoArgsConstructor
public class DoctorAvailabilityDTO {
    private Doctor.DaysOfTheWeek daysOfTheWeek;
    private Set<TimeSlot> timeSlots;
    private Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> weeklySchedule;

}
