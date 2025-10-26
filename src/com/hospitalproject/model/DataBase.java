package com.hospitalproject.model;

import java.sql.*;

public class DataBase {
	private static final String URL ="jdbc:mysql://localhost:3306/hospital_project";
	private static final String USER="root";
	private static final String PASSWORD="";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Database Connected");
		} catch (Exception e) {
			System.err.println("!!! VERITABANI BAĞLANTI HATASI !!!");
	        e.printStackTrace();
		}
		return connection;
	}
}

