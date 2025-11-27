package com.hospitalproject.dto;

import java.util.Date;

import com.hospitalproject.model.Appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListAllAppointmentDto {

	private String patientName;
	private String patientSurname;
	private String patientNationalId;
	private Date patientBirthDate;
	private String doctorName;
	private String doctorSurname;
	private String departmentName;
	private Date appointmentDate;
	private Date appointmentTime;
	private Appointment.STATUS appointmentStatus;

}
