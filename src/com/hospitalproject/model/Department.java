package com.hospitalproject.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "departments")
public class Department {
	
	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "department_name")
	private String name;
	
	@Column(name = "department_code")
	private String code;
	
	@OneToMany(mappedBy = "department")
	List<Doctor> listDoctor;
}
