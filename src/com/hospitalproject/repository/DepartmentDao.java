package com.hospitalproject.repository;

import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.Department;

import jakarta.persistence.TypedQuery;

public class DepartmentDao {
	
	public Department findByName(String name) {
		
		TypedQuery<Department> query = DataBase.entityManager.createQuery(              
				"SELECT dep FROM Department dep WHERE dep.name = :name",Department.class);    
		query.setParameter("name", name);
		return query.getSingleResult();
	}
}
