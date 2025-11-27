package com.hospitalproject.dto;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePatientDto {
	private Integer patientId;
	private String patientName;
	private String patientSurname;
	private String patientEmail;
	private String patientPassword;
	private String patientNationalId;
	private String patientPhoneNumber;
	private Date patientBirthDate;
	private Integer userId;
}
