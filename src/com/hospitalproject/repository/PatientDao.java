package com.hospitalproject.repository;

import java.util.List;

import com.hospitalproject.dto.ListAllPatientDto;
import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Patient;

public class PatientDao {
	
	public List<ListAllPatientDto> listAllPatient() {
		String listAllPatientQuery ="SELECT new com.hospitalproject.dto.ListAllPatientDto"+
					 "(p.id, u.name, u.surname,p.gender, p.nationalId, p.phoneNumber, p.birthDate) "+
					 "FROM Patient p " +
					 "JOIN p.user u ";
		
		return DataBase.entityManager.createQuery(listAllPatientQuery,ListAllPatientDto.class).getResultList();
	}

	public Patient find(Integer patientId) {
		return DataBase.entityManager.find(Patient.class, patientId);
	}
	
	public void save(Patient patient) {
		DataBase.entityManager.persist(patient);
	}

	public void update(Patient patient) {
		DataBase.entityManager.merge(patient);
	}

	public void delete(Patient patient) {
		DataBase.entityManager.remove(patient);
	}
}
