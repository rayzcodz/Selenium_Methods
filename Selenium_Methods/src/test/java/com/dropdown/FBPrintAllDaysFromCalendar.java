package com.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBPrintAllDaysFromCalendar {

//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RY\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/");
//		
//	//Select select_month = new Select(driver.findElement(By.id("month")));
//		
//	
//	
//	}
	
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	
	@Test
	public void select_Days_Test() {
		Select select_day = new Select(driver.findElement(By.id("day")));
		List<WebElement> day_values = select_day.getOptions();
		for(int i = 0; i <day_values.size(); i++) {
			String days = day_values.get(i).getText();
			System.out.println(days);
		}
		
		System.out.println();
	}
	
	@Test
	public void select_Months_Test() {
		Select select_months = new Select(driver.findElement(By.id("month")));
		List<WebElement> months_list = select_months.getOptions();
		for(int i = 0; i < months_list.size(); i++) {
			String months = months_list.get(i).getText();
			System.out.println(months);
		}
		
	}
	
	
}
