package com.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlDriver {
	
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver = new HtmlUnitDriver(); //AKA Ghost driver, Headles browser
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	}
	
	@Test
	public void capitalOneLoginTest() {
		driver.get("https://www.capitalone.com/");
		driver.findElement(By.id("no-acct-uid")).sendKeys("testUser");
		driver.findElement(By.id("no-acct-pw")).sendKeys("testPassword");
		driver.findElement(By.id("no-acct-pw")).click();
		System.out.println(driver.getTitle());
	}
	
/**
 Advantages of HtmlUnitDriver
 -fast
 -testing happens behind seen without opening browser
 
 Disadvantage of HtmlUnitDriver
 -not suitable for mouse movement like doule clik, drag and drop
 
 */


	
	

}
