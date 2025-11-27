package com.hospitalproject.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.dto.ListAllDoctorDto;
import com.hospitalproject.repository.DoctorDao;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter
public class DoctorBean {
	
	private DoctorDao doctorDao = new DoctorDao();
	
	public List<ListAllDoctorDto> getListDoctorForAdmin() {
		return doctorDao.listAllDoctor();
	}
}
