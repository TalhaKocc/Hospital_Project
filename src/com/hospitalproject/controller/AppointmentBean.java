package com.hospitalproject.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.dto.ListAllAppointmentDto;
import com.hospitalproject.repository.AppointmentDao;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter
public class AppointmentBean {
	private AppointmentDao appointmentDao = new AppointmentDao();
	
	public List<ListAllAppointmentDto> getListPatientForAdmin(){
		return appointmentDao.appointmentList();
	}
}
