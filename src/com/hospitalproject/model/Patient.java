package com.hospitalproject.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "patients")
public class Patient {
	
	@Column(name = "patient_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "patient_gender")
	private GENDER gender;
	
	@Column(name = "national_id")
	private String nationalId;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "date_birth")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "patient")
	List<Appointment> listAppointment;
	
	@OneToOne
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private User user;

	public enum GENDER{
		Male,
		Female
	}

}
