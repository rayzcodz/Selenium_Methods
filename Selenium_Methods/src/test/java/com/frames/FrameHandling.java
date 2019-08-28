package com.frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void urlTest() {
		driver.get("https://www.freecrm.com/index.html");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("yumukhov");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123456");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		
	}
	
	
	@Test(priority = 3)
	public void clickContactsTest() {
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//div[@id='navmenu']//a[.='Contacts']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}
	
	
	

}
