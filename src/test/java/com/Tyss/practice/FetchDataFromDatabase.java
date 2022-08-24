package com.Tyss.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://host1:3306/Techmax", "root", "root");
		Statement statement = connection.createStatement();
		String query="insert into empdetails values('venkat',24,'asdfgh@gmail.com');";
		int result = statement.executeUpdate(query);
		if(result==1){
			System.out.println("data present");
		}else{
			System.out.println("data not present");
		}
		connection.close();
	}

}
