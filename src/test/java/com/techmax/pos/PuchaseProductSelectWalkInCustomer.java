package com.techmax.pos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PuchaseProductSelectWalkInCustomer {

	public static void main(String[] args) throws IOException {
WebDriver driver=null;
		
		//Read the data from property file
		FileInputStream filePath=new FileInputStream(".\\Data\\CommonData.properties");
		Properties property=new Properties();
		property.load(filePath);
		String URL = property.getProperty("url");
		String USENAME = property.getProperty("username");
		String PASSWORD = property.getProperty("password");
		String BROWSER = property.getProperty("browser");
		
		//READ DATA FROM EXCELFILE
		FileInputStream fileEx=new FileInputStream(".\\Data\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fileEx);
		String quantity = book.getSheet("Sheet1").getRow(0).getCell(1).toString();
		String customer = book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		
		//launch the url
		if(BROWSER.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();			
		}else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else{
			System.out.println("INCORRECT BROWSER");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user")).sendKeys(USENAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		
		//navigate POS and select catagory
		
		driver.findElement(By.xpath("//span[.='POS']")).click();
		driver.findElement(By.xpath("//a[.='Mouse']")).click();
		driver.findElement(By.xpath("//h6[.='Zebronics']/../input[1]")).sendKeys(quantity);
		driver.findElement(By.xpath("//h6[.='Zebronics']/../input[4]")).click();
		
		
		//select a customer and click on submit
		WebElement dd1 = driver.findElement(By.xpath("//select[@name='customer']"));
		Select s=new Select(dd1);
		s.selectByVisibleText(customer);
		driver.findElement(By.xpath("//button[.='SUBMIT']")).click();
		WebElement ele = driver.findElement(By.name("total"));
		String amount = ele.getAttribute("value");
		driver.findElement(By.xpath("//input[@name='cash']")).sendKeys(amount);
		driver.findElement(By.xpath("//button[.='PROCEED TO PAYMENT']")).click();
		Alert b = driver.switchTo().alert();
		b.accept();
		
		
		
		//logout the application
		
		driver.findElement(By.xpath("//a[@id='userDropdown']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-item'][2]")).click();
		driver.close();
		System.out.println("Testcase complete");


	}

}
