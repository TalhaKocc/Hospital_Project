package com.hospitalproject.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class User {
	
	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private ROLE role;
	
	
	@OneToOne(mappedBy = "user")
	private Patient patient;
	
	@OneToOne(mappedBy = "user")
	private Doctor doctor;
	
	
	public enum ROLE{
		Admin,
		Doctor,
		Patient
	}
	
	
}
