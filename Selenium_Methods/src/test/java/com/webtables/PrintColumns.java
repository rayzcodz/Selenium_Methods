package com.webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintColumns {
	
	WebDriver driver;

	@BeforeClass 
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void printColumnsTest() {
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//Patter is only td is changing
		
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td"));
		int columnsCount= columns.size();
		
		String frontXpath = "//*[@id=\"customers\"]/tbody/tr[2]/td[";
		String backXpath = "]";
		
		for (int i = 1; i <= columnsCount; i++) {
			String wholeXpath = frontXpath + i + backXpath;
			String columnText = driver.findElement(By.xpath(wholeXpath)).getText();
			System.out.println(columnText);
		}
		
		
		
	}

}
