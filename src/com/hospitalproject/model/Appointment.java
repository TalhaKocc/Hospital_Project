package com.hospitalproject.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "appointment_date")
	private Date appointmentDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "appointment_time")
	private Date appointmentTimeDate;
	
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
