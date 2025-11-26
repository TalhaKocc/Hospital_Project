package com.hospitalproject.repository;

import com.hospitalproject.dto.AddPatientDto;
import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Patient;
import com.hospitalproject.model.User;
import com.hospitalproject.model.User.ROLE;

public class RegisterDao {
	// hasta tarafından sisteme kayıt olma sorgusu
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
}