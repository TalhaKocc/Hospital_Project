package com.hospitalproject.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "appointments")
public class Appointment {
 
	@Column(name = "appointment_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "appointment_date")
	private Date appointmentDate;
	
	@Column(name = "appointment_time")
	private Date appointmentDateTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "appointment_status")
	private STATUS status;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_id",referencedColumnName = "patient_id")
	private Patient patient;
	
	public enum STATUS{
		Available,  
	    Booked,      
	    Cancalled,   
	    Completed 
	}
}
