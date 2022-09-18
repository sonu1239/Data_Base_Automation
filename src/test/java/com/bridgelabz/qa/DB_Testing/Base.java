package com.bridgelabz.qa.DB_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public static Connection con;
	
	@BeforeTest
	public Connection setUp() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/cqa_106";
		String userName = "root";
		String pwd = "Sonu@1239";
		con = DriverManager.getConnection(url,userName,pwd);
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Sonu@1239");
		return con;
		
	}
	@AfterTest
	public void tearDown() throws SQLException {
		con.close();
	}
}