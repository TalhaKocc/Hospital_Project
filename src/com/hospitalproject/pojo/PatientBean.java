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
	private UserBean user;
	private String national_id;
	private String name;
	private String gender;
	private Date birth ;
	
}
