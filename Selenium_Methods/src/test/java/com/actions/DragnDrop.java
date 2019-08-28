package com.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragnDrop {
	WebDriver driver;
	Actions action;
	
	

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://jqueryui.com/droppable/");
		
	}
	
	@Test
	public void dragnDropTest() {
		action = new Actions(driver);
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		action.clickAndHold(source).moveToElement(target).release().build().perform();
		
		//Below method is also correct but it is cumbersome
		
		//action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
		//.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']")))
		//.release()
		//.build()
		//.perform();
		
	}
	

}
