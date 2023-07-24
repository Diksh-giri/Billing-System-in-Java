package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		return	DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SwingDb ","root","Root@123");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
}
