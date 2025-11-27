package com.hospitalproject.repository;

import java.util.List;
import com.hospitalproject.dto.ListAllAppointmentDto;
import com.hospitalproject.model.Appointment;
import com.hospitalproject.model.DataBase;
public class AppointmentDao {

	public List<ListAllAppointmentDto> appointmentList(){
		String listAllAppointmentQuery = "SELECT new com.hospitalproject.dto.ListAllAppointmentDto"+
				 "(p.user.name,p.user.surname,p.nationalId,p.birthDate,d.user.name,d.user.surname,dep.name,a.appointmentDate,a.appointmentDateTime,a.status) "+
				 "FROM Appointment a " +
				 "JOIN a.patient p " +
				 "JOIN a.doctor d " +
				 "JOIN d.department dep ";
		return DataBase.entityManager.createQuery(listAllAppointmentQuery,ListAllAppointmentDto.class).getResultList();
	}
	
	public List<ListAllAppointmentDto> appointmentListForDoctor(Integer doctorId){
		String listAllAppointmentQuery = "SELECT new com.hospitalproject.dto.ListAllAppointmentDto"+
				 "(p.user.name,p.user.surname,p.nationalId,p.birthDate,d.user.name,d.user.surname,dep.name,a.appointmentDate,a.appointmentDateTime,a.status) "+
				 "FROM Appointment a " +
				 "JOIN a.patient p " +
				 "JOIN a.doctor d " +
				 "JOIN d.department dep " +
				 "WHERE a.doctor.id = :doctorId" ;
		return DataBase.entityManager.createQuery(listAllAppointmentQuery,ListAllAppointmentDto.class)
				.setParameter("doctorId", doctorId)
				.getResultList();
	}
	
	public List<ListAllAppointmentDto> appointmentListForPatient(Integer patientId){
		String listAllAppointmentQuery = "SELECT new com.hospitalproject.dto.ListAllAppointmentDto"+
				 "(p.user.name,p.user.surname,p.nationalId,p.birthDate,d.user.name,d.user.surname,dep.name,a.appointmentDate,a.appointmentDateTime,a.status) "+
				 "FROM Appointment a " +
				 "JOIN a.patient p " +
				 "JOIN a.doctor d " +
				 "JOIN d.department dep " +
				 "WHERE a.patient.id = :patientId" ;
		return DataBase.entityManager.createQuery(listAllAppointmentQuery,ListAllAppointmentDto.class)
				.setParameter("patientId", patientId)
				.getResultList();
	}

	public void save(Appointment apoAppointment) {
		DataBase.entityManager.persist(apoAppointment);
	}
	
	public Appointment find(Integer appointmentId) {
		return DataBase.entityManager.find(Appointment.class, appointmentId);
	}
	
	public void delete(Appointment appointment) {
		DataBase.entityManager.remove(appointment);
	}
	
	public void update(Appointment appointment) {
		DataBase.entityManager.merge(appointment);
	}
}
