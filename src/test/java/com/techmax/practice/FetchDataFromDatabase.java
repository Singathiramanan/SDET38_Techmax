package com.techmax.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

//public class FetchDataFromDatabase {
//	public static void main(String[] args) throws SQLException {
//		//create an obj database driver cj.jdbc
//		Driver dbDriver=new Driver();
//		
//		//register the driver
//		DriverManager.registerDriver(dbDriver);
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/techmax", "root", "root");
//		Statement statement = connection.createStatement();
//		statement.executeUpdate("create table EmpDetails1(empTd int(4) not null unique,empName varchar(20),phNumber int(10) not null,address varchar(50) not null);");
//		connection.close();
//	}
//
//}


public class FetchDataFromDatabase {
	public static void main(String[] args) throws SQLException  {
		//create an obj database driver cj.jdbc
		@SuppressWarnings("unused")
		Driver dbDriver=new Driver();
		Connection connection =null;
		 
		//register the drive//		DriverManager.registerDriver(dbDriver);
		try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/techmax", "root", "root");
		Statement statement = connection.createStatement();
		statement.executeUpdate("create table EmpDetails1(empTd int(4) not null unique,empName varchar(20),phNumber int(10) not null,address varchar(50) not null);");
		}
		finally{
		connection.close();
		}
	}
}
	

