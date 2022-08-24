package com.Tyss.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyfile {

	public static void main(String[] args) throws IOException {
		//use file input stream load the property file
				FileInputStream fis = new FileInputStream(".\\Data\\CommonData.properties");
				
				//create an object and load the file
				Properties pro=new Properties();
				pro.load(fis);
				
				//provide the key read the value
				String URL = pro.getProperty("url");
				System.out.println(URL);
				String USERNAME = pro.getProperty("username");
				System.out.println(USERNAME);
				String PASSWORD = pro.getProperty("password");
				System.out.println(PASSWORD);
				String BROWSER = pro.getProperty("browser");
				System.out.println(BROWSER);

	}

}
