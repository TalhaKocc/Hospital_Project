package com.hospitalproject.repository;

import java.util.List;

import com.hospitalproject.dto.ListAllDoctorDto;
import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Doctor;


public class DoctorDao {

	public List<ListAllDoctorDto> listAllDoctor() {
		String listAllDoctorQuery ="SELECT new com.hospitalproject.dto.ListAllDoctorDto"+
					 "(d.id, u.name, u.surname,dep.name,d.phoneNumber, d.roomNumber,d.gender , d.salary) "+
					 "FROM Doctor d " +
					 "JOIN d.user u " +
					 "JOIN d.department dep";
		
		return DataBase.entityManager.createQuery(listAllDoctorQuery,ListAllDoctorDto.class).getResultList();

	}
	
	public void save(Doctor doctor) {
		DataBase.entityManager.persist(doctor);
	}

	public Doctor find(Integer doctorId) {
		return DataBase.entityManager.find(Doctor.class, doctorId);
	}

	public void update(Doctor doctor) {
		DataBase.entityManager.merge(doctor);
	}
	
	public void delete(Doctor doctor) {
		DataBase.entityManager.remove(doctor);
	}
}
