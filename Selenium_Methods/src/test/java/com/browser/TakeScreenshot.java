package com.browser;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void takeScreenShotTest() throws IOException {
		//Takes screen shot and saves as file format
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Now copy the screen shot to a desider location using copyFile() method
		FileUtils.copyFile(screenShot, new File("C:\\Users\\RY\\eclipse-workspace\\yumukhov-automation\\src\\test\\java\\com\\browser\\youtube.png"));
	}
	
	

}
