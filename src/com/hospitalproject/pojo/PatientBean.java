package com.hospitalproject.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientBean {
	private int id;
	private String gender;
	private String national_id;	
	private String phoneNumber;
	private Date birthDate ;
	private UserBean user;
}
