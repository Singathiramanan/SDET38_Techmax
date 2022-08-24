package com.techmax.pos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Booking_in_trivogo {

	public static void main(String[] args) {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//launch URL
		driver.get("https://www.goibibo.com/");
		
		//Avoid login pop up
		driver.findElement(By.xpath("//body[@class='desktop']")).click();
		
		//selecting From and To location
		driver.findElement(By.xpath("//span[.='From']/following-sibling::p")).click();
		driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']/input")).sendKeys("Bangaluru");
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li[1]")).click();
		//driver.findElement(By.xpath("//span[.='To']/following-sibling::p")).click();
		driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']/input")).sendKeys("Madurai");
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li[1]")).click();
		
		//select departure and return date
		//driver.findElement(By.xpath("//span[.='Departure']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Sun Oct 23 2022']")).click();
		driver.findElement(By.xpath("//p[.=' Click to add a return flight for better discounts']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Sat Oct 29 2022']")).click();
		driver.findElement(By.xpath("//body[@class='desktop']")).click();
		
		//Add passenger
		driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
		driver.findElement(By.xpath("//*[name()='svg' and @width='15' and @height='15'][1]")).click();
		driver.findElement(By.xpath("//a[.='Done']")).click();
		
		//searching flight
		driver.findElement(By.xpath("//span[.='SEARCH FLIGHTS']")).click();


	}

}
