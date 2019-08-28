package com.element;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIs {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/register/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1) //Tests whether an elemtnis displayed. Does not matter if you can click it or not.
	public void isDisplayedTest() {
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println("isDisplayedTest: " + b1); //true
	}


	@Test (priority = 2) //will return false if you cannot click on the element
	public void isEnabledTest() {
		boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("isEnabledTest: " + b2); //false
	}
	


	@Test(priority = 3) //will return false if you cannot click on the element
	public void clickCheckBoxTest() {
		driver.findElement(By.name("agreeTerms")).click();
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("Element enabled?  " + b3); //now it will return true. Because we clicked the "agree" button
	}
	

	@Test (priority = 4) //will return false if you cannot click on the element
	public void isSelectedTest1() {
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("Element selected?  " + b4); 	}

	
	@Test (priority = 5) //will return false if you cannot click on the element
	public void isSelectedTest2() {
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();

		System.out.println("Element selected?  " + b5); //now it will return true. Because we clicked the "agree" button
	}

				

}
