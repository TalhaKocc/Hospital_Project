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
		
		
		
		UpdateDoctorDto updateDoctorDto = new UpdateDoctorDto();
		updateDoctorDto.setDoctorId(16);
		updateDoctorDto.setUserId(65);
		updateDoctorDto.setDoctorName("Hafsa");
		updateDoctorDto.setDoctorSurname("Koç");
		updateDoctorDto.setDoctorEmail("hafsa.koc@hastane.com");
		updateDoctorDto.setDoctorPassword("hafsa1234");
		updateDoctorDto.setDoctorPhoneNumber("05412458978");
		updateDoctorDto.setDoctorRoomNumber("HAFSA001");
		
		DoctorDao doctorDao = new DoctorDao();
		doctorDao.updateDoctor(updateDoctorDto);
		

	}
}
