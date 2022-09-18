package com.bridgelabz.qa.DB_Testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base{
	@Test
	public void getTableData() throws SQLException {
		con=this.setUp();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select *  from employee_tb");
		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		int id = rs.getInt(1);								        
                    String name = rs.getString(2);
                    String occupation = rs.getString(3);
                    int age = rs.getInt(4);
                    System. out.println(id+" "+name+" "+occupation+" "+age);
		}
	}
	
	//Inserting Method
	
	@Test
	public void insertData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("insert into employee_tb(id,name,occupation,age) values(?,?,?,?)");
		stmt.setInt(1,5);
		stmt.setString(2, "puneet");
		stmt.setString(3, "tester");
		stmt.setInt(4, 27);

		stmt.executeUpdate();
		getTableData();
	}
	
	//Updating Method
		@Test
		public void updateData() throws SQLException {
			con=this.setUp();
			PreparedStatement stmt = con.prepareStatement("update employee_tb set name='vishal'  where id=2 ");
			stmt.executeUpdate();
			getTableData();
		}
		
		//Deleting Method
		@Test
		public void deleteData() throws SQLException {
			con=this.setUp();
			PreparedStatement stmt = con.prepareStatement("delete from employee_tb where id=5 ");
			stmt.executeUpdate();
			getTableData();
		}
}