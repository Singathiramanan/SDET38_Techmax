package com.techmax.practice;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotEFWD {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		Random random=new Random();
		int ran = random.nextInt(50);
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		//TakesScreenshot ts=(TakesScreenshot)driver;
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+ran+".jpeg");
		FileHandler.copy(src, dst);
		//FileUtils.copyFile(src, dst);
	}

}
