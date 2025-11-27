package com.hospitalproject.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.dto.AddPatientDto;
import com.hospitalproject.service.PatientService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter
public class PatientBean {

	private AddPatientDto addPatientDto = new AddPatientDto();
	private PatientService patientService = new PatientService();
	
	public String addPatient() {
		patientService.addPatient(addPatientDto);
		return"login.xhtml?faces-redirect=true";
	}
}
