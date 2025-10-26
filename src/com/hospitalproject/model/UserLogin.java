package com.hospitalproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hospitalproject.dao.LoginDao;
import com.hospitalproject.pojo.UserBean;

import static com.hospitalproject.model.DataBase.getConnection;
public class UserLogin implements LoginDao {
	private String loginSql="SELECT user_id,eposta,role FROM users WHERE eposta=? AND password=?  ";
	
	@Override
	public UserBean logginUser(UserBean userBean) {
		UserBean loggedUser=null;
		
		try (Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(loginSql);){
			 
			 
			 pstmt.setString(1,userBean.getEposta());
			 pstmt.setString(2, userBean.getPassword());
			 
			 ResultSet rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 loggedUser = new UserBean();
				 loggedUser.setId(rs.getInt("user_id"));
				 loggedUser.setEposta(rs.getString("eposta"));
				 loggedUser.setRole(rs.getString("role"));
			 }else {
				System.out.println("kullanıcı Bulunamadı");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loggedUser;
	} 
}
