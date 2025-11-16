package com.hospitalproject;

import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.User;

public class App {

	public static void main(String[] args) {
		
		DataBase dataBase = new DataBase();
		User user = dataBase.entityManager.find(User.class, 1);
		
		dataBase.transaction.begin();
		user.setName("Talha");
		user.setSurname("Koç");
		user.setPassword("talha123");
		user.setEmail("talhakoc@admin.com");
		user.setRole(User.ROLE.Admin);
		dataBase.entityManager.persist(user);
		dataBase.transaction.commit();
	}
}
