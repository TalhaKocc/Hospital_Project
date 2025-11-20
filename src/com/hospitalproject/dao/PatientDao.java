package com.hospitalproject.dao;


import java.util.List;

import com.hospitalproject.dto.AddPatientDto;
import com.hospitalproject.dto.ListAllPatientDto;
import com.hospitalproject.dto.UpdatePatientDto;
import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Patient;
import com.hospitalproject.model.User;
import com.hospitalproject.model.User.ROLE;


public class PatientDao {
	
	public List<ListAllPatientDto> listAllPatient() {
		String listAllPatientQuery ="SELECT new com.hospitalproject.dto.ListAllPatientDto"+
					 "(p.id, u.name, u.surname,p.gender, p.nationalId, p.phoneNumber, p.birthDate) "+
					 "FROM Patient p " +
					 "JOIN p.user u ";
		
		return DataBase.entityManager.createQuery(listAllPatientQuery,ListAllPatientDto.class).getResultList();

	}

	public void addPatient(AddPatientDto addPatientDto) {
		try {
			
			DataBase.transaction.begin();
			User user = new User();
			user.setName(addPatientDto.getPatientName());
			user.setSurname(addPatientDto.getPatientSurname());
			user.setEmail(addPatientDto.getPatientEmail());
			user.setPassword(addPatientDto.getPatientPassword());
			user.setRole(ROLE.Patient);
			DataBase.entityManager.persist(user);
			
			Patient patient = new Patient();
			patient.setGender(addPatientDto.getPatientGender());
			patient.setNationalId(addPatientDto.getPatientNationalId());
			patient.setPhoneNumber(addPatientDto.getPatientPhoneNumber());
			patient.setBirthDate(addPatientDto.getPatientBirthDate());
			patient.setUser(user);
			DataBase.entityManager.persist(patient);
			DataBase.transaction.commit();
			
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}
	}

	public void updatePatient(UpdatePatientDto updatePatientDto) {
			
			DataBase.transaction.begin();
			
			User user = DataBase.entityManager.find(User.class,updatePatientDto.getUserId());
			
			user.setName(updatePatientDto.getPatientName());
			user.setSurname(updatePatientDto.getPatientSurname());
			user.setEmail(updatePatientDto.getPatientEmail());
			user.setPassword(updatePatientDto.getPatientPassword());
			DataBase.entityManager.merge(user);
			
			Patient patient = DataBase.entityManager.find(Patient.class, updatePatientDto.getPatientId());
			patient.setNationalId(updatePatientDto.getPatientNationalId());
			patient.setPhoneNumber(updatePatientDto.getPatientPhoneNumber());
			patient.setBirthDate(updatePatientDto.getPatientBirthDate());
			DataBase.entityManager.merge(patient);
			
			DataBase.transaction.commit();
	}

	public void removePatient(Integer patientId) {
		DataBase.transaction.begin();
		
		Patient patient = DataBase.entityManager.find(Patient.class, patientId);
		
		User user = patient.getUser();
		
		DataBase.entityManager.remove(patient);
		DataBase.entityManager.remove(user);
		
		DataBase.transaction.commit();
	}
}
