package com.hospitalproject.service;

import com.hospitalproject.dto.AddPatientDto;
import com.hospitalproject.dto.UpdatePatientDto;
import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Patient;
import com.hospitalproject.model.User;
import com.hospitalproject.model.User.ROLE;
import com.hospitalproject.repository.PatientDao;
import com.hospitalproject.repository.UserDao;

public class PatientService {

	private PatientDao patientDao = new PatientDao();
	private UserDao userDao = new UserDao();
	
	public void addPatient(AddPatientDto addPatient) {
		try {
			DataBase.transaction.begin();
			
			User user = new User();
			user.setName(addPatient.getPatientName());
			user.setSurname(addPatient.getPatientSurname());
			user.setEmail(addPatient.getPatientEmail());
			user.setPassword(addPatient.getPatientPassword());
			user.setRole(ROLE.Patient);
			userDao.save(user);
			
			Patient patient = new Patient();
			patient.setUser(user);
			patient.setGender(addPatient.getPatientGender());
			patient.setNationalId(addPatient.getPatientNationalId());
			patient.setPhoneNumber(addPatient.getPatientPhoneNumber());
			patient.setBirthDate(addPatient.getPatientBirthDate());
			patientDao.save(patient);
			
			DataBase.transaction.commit();
			
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void updatePatient(UpdatePatientDto updatePatient) {
		try {
			DataBase.transaction.begin();
			
			User user = userDao.find(updatePatient.getUserId());
			user.setName(updatePatient.getPatientName());
			user.setSurname(updatePatient.getPatientSurname());
			user.setEmail(updatePatient.getPatientEmail());
			user.setPassword(updatePatient.getPatientPassword());
			userDao.update(user);
			
			Patient patient = patientDao.find(updatePatient.getPatientId());
			patient.setNationalId(updatePatient.getPatientNationalId());
			patient.setPhoneNumber(updatePatient.getPatientPhoneNumber());
			patient.setBirthDate(updatePatient.getPatientBirthDate());
			patientDao.update(patient);
			
			DataBase.transaction.commit();
			
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void deletePatient(Integer patientId) {
		try {
			DataBase.transaction.begin();
			
			Patient patient = patientDao.find(patientId);
			User user = patient.getUser();
			patientDao.delete(patient);
			userDao.delete(user);
			DataBase.transaction.commit();
			
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}
	}
}
