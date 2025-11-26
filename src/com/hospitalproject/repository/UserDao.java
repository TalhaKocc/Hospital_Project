package com.hospitalproject.repository;

import com.hospitalproject.model.DataBase;
import com.hospitalproject.model.User;

public class UserDao {
	
	// login işlemi için kullanılan sorgu
	public User login(String email,String password) {
		try {
			String jpql = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
		
			return DataBase.entityManager
					.createQuery(jpql,User.class)
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

	public User find(Integer userId) {
		return DataBase.entityManager.find(User.class, userId);
	}

	public void save(User user) {
		DataBase.entityManager.persist(user);
	}

	public void update(User user) {
		DataBase.entityManager.merge(user);
	}

	public void delete(User user) {
		DataBase.entityManager.remove(user);
	}
}
