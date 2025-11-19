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
	private Integer id;
	
	@Column(name = "department_code")
	private String code;
	
	@Column(name = "department_name")
	private String name;
	
	@OneToMany(mappedBy = "department")
	List<Doctor> listDoctor;
}
