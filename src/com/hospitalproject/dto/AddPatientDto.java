package com.hospitalproject.dto;


import java.time.LocalDate;
import java.util.Date;

import com.hospitalproject.model.Patient;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPatientDto {
	private String patientName;
	private String patientSurname;
	private String patientEmail;
	private String patientPassword;
	private Patient.GENDER patientGender;
	private String patientNationalId;
	private String patientPhoneNumber;
	private Date patientBirthDate;
}
