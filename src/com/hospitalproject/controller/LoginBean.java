package com.hospitalproject.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hospitalproject.dao.LoginDao;
import com.hospitalproject.model.UserLogin;
import com.hospitalproject.pojo.UserBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ManagedBean
@SessionScoped
public class LoginBean  implements Serializable{
	private static final long serialVersionUID=1L;
	private String eposta;
	private String password;
	private UserBean sessionUser;
	
	public String login() {
		UserBean user = new UserBean();
		user.setEposta(eposta);
		user.setPassword(password);
		LoginDao loginDao = new UserLogin();
		
		sessionUser = loginDao.logginUser(user);
		if(sessionUser!=null) {
			switch(sessionUser.getRole()) {
			case "Admin": return "/admin_dashboard.xhtml?faces-redirect=true";
            case "Doctor": return "/doctor_dashboard.xhtml?faces-redirect=true";
            case "Patient": return "/patient_dashboard.xhtml?faces-redirect=true";
            default: return "/login.xhtml?faces-redirect=true";
			}
		}else {
			System.out.println("hata");
		}
		
		
		
		return null;
	}
	
	
}
