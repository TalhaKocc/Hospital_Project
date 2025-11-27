package com.hospitalproject.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.model.Department;
import com.hospitalproject.repository.DepartmentDao;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter
public class DepartmentBean {

	private DepartmentDao departmentDao = new DepartmentDao();
	
	public List<Department> getlistDepartmentForAdmin() {
		return departmentDao.listDepartment();
	}
}
