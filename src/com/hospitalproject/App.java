package com.hospitalproject;

import com.hospitalproject.dao.PatientDao;

public class App {

	public static void main(String[] args) {
		PatientDao patientDao = new PatientDao();
		patientDao.removePatient(21);
		

	}
}
