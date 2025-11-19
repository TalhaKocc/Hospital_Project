package com.hospitalproject;

import java.util.List;

import com.hospitalproject.dao.DoctorDao;
import com.hospitalproject.dto.AddDoctorDto;
import com.hospitalproject.dto.ListAllDoctorDto;
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
		
		
		
		AddDoctorDto addDoctorDto = new AddDoctorDto();
		addDoctorDto.setDoctorName("Hafsa");
		addDoctorDto.setDoctorSurname("Koç");
		addDoctorDto.setDoctorEmail("hafsa.koc@hastane.com");
		addDoctorDto.setDoctorPassword("hafsa123");
		addDoctorDto.setDoctorDepartment("Dahiliye");
		addDoctorDto.setDoctorPhoneNumber("05412458978");
		addDoctorDto.setDoctorRoomNumber("HAF001");
		addDoctorDto.setDoctorGender(GENDER.Female);
		addDoctorDto.setDoctorSalary(100_000.10);
		
		DoctorDao dao = new DoctorDao();
		dao.addDoctor(addDoctorDto);
	}
}
