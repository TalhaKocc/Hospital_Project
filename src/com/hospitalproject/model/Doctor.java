package com.hospitalproject.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "doctors")
public class Doctor {
	
	@Column(name = "doctor_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "room_number")
	private String roomNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private GENDER gender;
	
	@Column(name = "salary")
	private Double salary;
	
	@OneToOne
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "department_id",referencedColumnName = "department_id")
	private Department department;
	
	@OneToMany(mappedBy = "doctor")
	List<Appointment> listAppointment;
	
	public enum GENDER {
		Male,
		Female
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", phoneNumber=" + phoneNumber + ", roomNumber=" + roomNumber + ", gender=" + gender
				+ ", salary=" + salary + "]";
	}

	
	
}
