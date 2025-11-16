package com.hospitalproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorBean {
	private int id;
	private String phoneNumber;
	private String roomNumber;
	private String gender;
	private double salary;
	private UserBean user;	
	private DepartmentBean department;
}
