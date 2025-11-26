package com.hospitalproject.service;

import com.hospitalproject.dto.AddDoctorDto;
import com.hospitalproject.dto.UpdateDoctorDto;
import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Department;
import com.hospitalproject.model.Doctor;
import com.hospitalproject.model.User;
import com.hospitalproject.model.User.ROLE;
import com.hospitalproject.repository.DepartmentDao;
import com.hospitalproject.repository.DoctorDao;
import com.hospitalproject.repository.UserDao;

public class DoctorService {
	
	private DoctorDao doctorDao = new DoctorDao();
	private UserDao userDao = new UserDao();
	private DepartmentDao departmentDao = new DepartmentDao(); 
	
	public void addDoctor(AddDoctorDto addDoctor) {

		try {
			DataBase.transaction.begin();
			
			User user = new User();
			user.setName(addDoctor.getDoctorName());
			user.setSurname(addDoctor.getDoctorSurname());
			user.setEmail(addDoctor.getDoctorEmail());
			user.setPassword(addDoctor.getDoctorPassword());
			user.setRole(ROLE.Doctor);
			userDao.save(user);

			Department department = departmentDao.findByName(addDoctor.getDoctorDepartment());
			
			Doctor doctor = new Doctor();
			doctor.setUser(user);
			doctor.setDepartment(department);
			doctor.setPhoneNumber(addDoctor.getDoctorPhoneNumber());
			doctor.setRoomNumber(addDoctor.getDoctorRoomNumber());
			doctor.setGender(addDoctor.getDoctorGender());
			doctor.setSalary(addDoctor.getDoctorSalary());
			doctorDao.save(doctor);
			
			DataBase.transaction.commit();
			
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}
	}

	public void updateDoctor(UpdateDoctorDto updateDoctor) {
		try {
			DataBase.transaction.begin();
			
			User user = userDao.find(updateDoctor.getUserId());
			user.setName(updateDoctor.getDoctorName());
			user.setSurname(updateDoctor.getDoctorSurname());
			user.setEmail(updateDoctor.getDoctorEmail());
			user.setPassword(updateDoctor.getDoctorPassword());
			userDao.update(user);
			
			Doctor doctor = doctorDao.find(updateDoctor.getDoctorId());
			doctor.setPhoneNumber(updateDoctor.getDoctorPhoneNumber());
			doctor.setRoomNumber(updateDoctor.getDoctorRoomNumber());
			doctorDao.update(doctor);
			
			DataBase.transaction.commit();
		} catch (Exception e) {
			
		}
	}

	public void updateDoctorSalary(Integer doctorId,Double salary) {
		try {
			DataBase.transaction.begin();
		
			Doctor doctor = doctorDao.find(doctorId);
			doctor.setSalary(salary);
			doctorDao.update(doctor);
			DataBase.transaction.commit();	
		
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}
		
		
	}

	public void deleteDoctor(Integer doctorId) {
		try {
			DataBase.transaction.begin();
			Doctor doctor = doctorDao.find(doctorId);
			User user = doctor.getUser();
		
			doctorDao.delete(doctor);
			userDao.delete(user);
			DataBase.transaction.commit();
		
		} catch (Exception e) {
			if(DataBase.transaction.isActive()) DataBase.transaction.rollback();
			e.printStackTrace();
		}

	}
}




