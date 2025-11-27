package com.hospitalproject.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.dto.AddPatientDto;
import com.hospitalproject.dto.ListAllPatientDto;
import com.hospitalproject.repository.PatientDao;
import com.hospitalproject.service.PatientService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter
public class PatientBean {

	private AddPatientDto addPatientDto = new AddPatientDto();
	private PatientService patientService = new PatientService();
	private PatientDao patientDao = new PatientDao();
	
	public String addPatient() {
		patientService.addPatient(addPatientDto);
		return"login.xhtml?faces-redirect=true";
	}

	public List<ListAllPatientDto> getListPatientForAdmin(){
		return patientDao.listAllPatient();
	}
}
