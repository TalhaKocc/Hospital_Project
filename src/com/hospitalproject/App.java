package com.hospitalproject;

import java.util.List;

import com.hospitalproject.dao.DoctorDao;
import com.hospitalproject.dto.AddDoctorDto;
import com.hospitalproject.dto.UpdateDoctorDto;
import com.hospitalproject.model.Doctor.GENDER;


public class App {

	public static void main(String[] args) {
		
		/*
		DoctorDao doctorDao = new DoctorDao();
		List<ListAllDoctorDto> listAllDoctorDto = doctorDao.listAllDoctor();
		
		for (ListAllDoctorDto doctor: listAllDoctorDto) {
			System.out.println(doctor);
		}
		*/
		
		
		
		DoctorDao doctorDao = new DoctorDao();
		doctorDao.updateSalaryDoctor(15, 100_000.00);
		

	}
}
