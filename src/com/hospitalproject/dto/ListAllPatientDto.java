package com.hospitalproject.dto;

import java.util.Date;

import com.hospitalproject.model.Patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListAllPatientDto {
	private Integer patientId;
	private String patientName;
	private String patientSurname;
	private Patient.GENDER patientGender;
	private String nationalId;
	private String patientPhoneNumber;
	private Date patientBirthDate;
}
