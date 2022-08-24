package com.Tyss.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheInsertingData {

	public static void main(String[] args) throws SQLException {
		// creating on object for driver
				Driver dbDriver=new Driver();
				
				//register the driver
				DriverManager.registerDriver(dbDriver);
				//Establish connection -mention database name
				Connection connection = DriverManager.getConnection("jdbc:mysql://host1:3306/Techmax", "root", "root");
				
				//create the statement
				Statement statement = connection.createStatement();
				
				//execute the query
				String query="select * from empdetails;";
				String expData="venkat";
				boolean flag=false;
				
				//validation
				ResultSet result = statement.executeQuery(query);
				while(result.next()){
					String value = result.getString(1);
					if(value.equalsIgnoreCase(expData)){
						System.out.println(value);
						flag=true;
						break;
					}
					if(flag==true){
						System.out.println("data present");
					}else{
						System.out.println("data not present");
					}
				}
				//close connection
				connection.close();


	}

}
