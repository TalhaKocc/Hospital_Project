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
	private UserBean user;
	private String name;
	private String gender;
	private DepartmentBean department;
	
}
