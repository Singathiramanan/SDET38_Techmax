package com.techmax.practice;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartMobiles {
	@Test
	public void MobileNames(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("redmi12pro plus");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		LinkedList<String> listname=new LinkedList<String>();
//		LinkedList<String> listprice=new LinkedList<String>();
		for(WebElement n1:names){
			String s1 = n1.getText().toString();
			System.out.println(s1);
			listname.add(s1);
		}
	}

}
