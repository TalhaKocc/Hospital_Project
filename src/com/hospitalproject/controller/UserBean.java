package com.hospitalproject.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.model.User;
import com.hospitalproject.repository.UserDao;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter
public class UserBean{
	private String email;
	private String password;
	private User loggedUser;
	
	public String login() {
		UserDao userDao = new UserDao();
		loggedUser = userDao.login(email, password);
		
		if(loggedUser == null) {
			return "login.xhtml?fces-redirect=true&error=true";
		}
		
		switch (loggedUser.getRole()) {
			case Admin: {
				return "admin-dashboard.xhtml?faces-redirect=true";
			}
		
			case Doctor:{
				return "doctor-dashboard.xhtml?faces-redirect=true";
			}
		
			case Patient:{
				return "patient-dashboard.xhtml?faces-redirect=true";
			}
		
			default:{
				return "login.xhtml?fces-redirect=true";
			}
		}
   }

	public String logout() {
		loggedUser = null;
		return "login.xhtml?fces-redirect=true";
	}
}