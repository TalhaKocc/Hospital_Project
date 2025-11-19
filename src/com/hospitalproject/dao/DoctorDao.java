package com.hospitalproject.dao;

import java.util.List;

import com.hospitalproject.dto.AddDoctorDto;
import com.hospitalproject.dto.ListAllDoctorDto;
import com.hospitalproject.dto.UpdateDoctorDto;
import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Department;
import com.hospitalproject.model.Doctor;
import com.hospitalproject.model.User;
import com.hospitalproject.model.User.ROLE;


import jakarta.persistence.TypedQuery;

public class DoctorDao {
	public List<ListAllDoctorDto> listAllDoctor() {
		String listAllDoctorQuery ="SELECT new com.hospitalproject.dto.ListAllDoctorDto"+
					 "(d.id, u.name, u.surname,dep.name,d.phoneNumber, d.roomNumber,d.gender , d.salary) "+
					 "FROM Doctor d " +
					 "JOIN d.user u " +
					 "JOIN d.department dep";
		
		return DataBase.entityManager.createQuery(listAllDoctorQuery,ListAllDoctorDto.class).getResultList();

	}
	
	public void addDoctor(AddDoctorDto addDoctor) {

		try {
			
			DataBase.transaction.begin();
			User user = new User();
			user.setName(addDoctor.getDoctorName());
			user.setSurname(addDoctor.getDoctorSurname());
			user.setEmail(addDoctor.getDoctorEmail());
			user.setPassword(addDoctor.getDoctorPassword());
			user.setRole(ROLE.Doctor);
			DataBase.entityManager.persist(user);
			
			TypedQuery<Department> query = DataBase.entityManager.createQuery(              
					"SELECT dep FROM Department dep WHERE dep.name = :name",Department.class);    
			query.setParameter("name", addDoctor.getDoctorDepartment());
			Department department = query.getSingleResult();
			
			Doctor doctor = new Doctor();
			doctor.setDepartment(department);
			doctor.setPhoneNumber(addDoctor.getDoctorPhoneNumber());
			doctor.setRoomNumber(addDoctor.getDoctorRoomNumber());
			doctor.setGender(addDoctor.getDoctorGender());
			doctor.setSalary(addDoctor.getDoctorSalary());
			doctor.setUser(user);
			DataBase.entityManager.persist(doctor);
			
			DataBase.transaction.commit();
			
			
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}
	}

	public void updateDoctor(UpdateDoctorDto updateDoctor) {
		DataBase.transaction.begin();
		
		User user = DataBase.entityManager.find(User.class, updateDoctor.getUserId());
		
		user.setName(updateDoctor.getDoctorName());
		user.setSurname(updateDoctor.getDoctorSurname());
		user.setEmail(updateDoctor.getDoctorEmail());
		user.setPassword(updateDoctor.getDoctorPassword());
		DataBase.entityManager.merge(user);
		
		Doctor doctor = DataBase.entityManager.find(Doctor.class, updateDoctor.getDoctorId());
		doctor.setPhoneNumber(updateDoctor.getDoctorPhoneNumber());
		doctor.setRoomNumber(updateDoctor.getDoctorRoomNumber());
		DataBase.entityManager.merge(doctor);
		
		DataBase.transaction.commit();
	}
	
}
