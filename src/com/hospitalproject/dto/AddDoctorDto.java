package com.hospitalproject.dto;

import com.hospitalproject.model.Doctor;
import com.hospitalproject.model.User;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddDoctorDto {
	private String doctorName;
	private String doctorSurname;
	private String doctorEmail;
	private String doctorPassword;
	private User.ROLE userRole;
	private String doctorDepartment;
	private String doctorPhoneNumber;
	private String doctorRoomNumber;
	private Doctor.GENDER doctorGender;
	private Double doctorSalary;
}
