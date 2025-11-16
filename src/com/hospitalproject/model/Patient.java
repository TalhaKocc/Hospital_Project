package com.hospitalproject.model;

import java.util.Date;
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
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "patient_gender")
	private GENDER gender;
	
	@Column(name = "national_id")
	private long nationalId;
	
	@Column(name = "phone_number")
	private long phoneNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_birth")
	private Date birthDate;
	
	@OneToMany(mappedBy = "patient")
	List<Appointment> listAppointment;
	
	@OneToOne
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private User user;

	public enum GENDER{
		Erkek,
		Kadın
	}

}
