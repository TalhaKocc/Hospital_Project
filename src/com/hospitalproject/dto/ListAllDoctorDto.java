package com.hospitalproject.dto;

import com.hospitalproject.model.Doctor;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListAllDoctorDto {
	private Integer doctorId;
	private String doctorName;
	private String doctorSurname;
	private String doctorDepartment;
	private String doctorPhoneNumber;
	private String doctorRoomNumber;
	private Doctor.GENDER doctorGender;
	private Double doctorSalary;
}
