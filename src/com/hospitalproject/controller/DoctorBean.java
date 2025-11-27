package com.hospitalproject.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.dto.ListAllDoctorDto;
import com.hospitalproject.repository.DoctorDao;
import com.hospitalproject.service.DoctorService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter
public class DoctorBean {
	private Integer doctorId;
	private Double salary;
	
	private DoctorDao doctorDao = new DoctorDao();
	private DoctorService doctorService = new DoctorService(); 
	
	public List<ListAllDoctorDto> getListDoctorForAdmin() {
		return doctorDao.listAllDoctor();
	}

	public String deleteDoctor(Integer id) {
		doctorService.deleteDoctor(id);
		return "admin-doctor-list?faces-redirect=true";
	}

	public String goToSalaryPage(Integer doctorId) {
		this.doctorId=doctorId;
		return "admin-doctor-salary-update.xhtml?faces-redirect=true";
	}
	
	public String updateDoctorSalary() {
		doctorService.updateDoctorSalary(doctorId, salary);
		
		return "admin-doctor-list.xhtml?faces-redirect=true";
	}
}
