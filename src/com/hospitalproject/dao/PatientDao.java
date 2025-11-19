package com.hospitalproject.dao;

import java.util.List;

import com.hospitalproject.dto.ListAllPatientDto;
import com.hospitalproject.model.DataBase;


public class PatientDao {
	
	public List<ListAllPatientDto> listAllPatient() {
		String listAllPatientQuery ="SELECT new com.hospitalproject.dto.ListAllPatientDto"+
					 "(p.id, u.name, u.surname,p.gender, p.nationalId, p.phoneNumber, p.birthDate) "+
					 "FROM Patient p " +
					 "JOIN p.user u ";
		
		return DataBase.entityManager.createQuery(listAllPatientQuery,ListAllPatientDto.class).getResultList();

	}

}
