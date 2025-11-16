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
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "appointment_date")
	private Date appointmentDate;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_id",referencedColumnName = "patient_id")
	private Patient patient;
}
