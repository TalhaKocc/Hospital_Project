package com.hospitalproject.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.hospitalproject.model.Appointment;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListAllAppointmentDto {

	private String patientName;
	private String patientSurname;
	private String patientNationalId;
	private LocalDate patientAge;
	private String doctorName;
	private String doctorSurname;
	private String departmentName;
	private LocalDate appointmentDate;
	private LocalDateTime appointmentTime;
	private Appointment.STATUS appointmentStatus;

	public Integer getPatientAge() {
		if(patientAge == null) return null;
		return Period.between(patientAge, LocalDate.now()).getYears();
	}
}
