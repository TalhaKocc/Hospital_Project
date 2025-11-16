package com.hospitalproject.model;

import jakarta.persistence.*;

public class DataBase {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalProject");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction transaction = entityManager.getTransaction();
}

