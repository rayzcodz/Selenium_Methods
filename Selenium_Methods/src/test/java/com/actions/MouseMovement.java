package com.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovement {
	WebDriver driver;
	Actions action;
	
	@BeforeClass 
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
	}
	
	@Test
	public void dropdownTest() throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-shopall']"))).build().perform();
		driver.findElement(By.xpath("//span[text()='Electronics, Computers & Office']")).click();
	
	}
	
}
