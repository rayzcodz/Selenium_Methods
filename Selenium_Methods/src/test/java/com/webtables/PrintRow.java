package com.webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This is table head //*[@id="customers"]/tbody/tr[1]/th[1]
 * 
 * These are table rows //*[@id='customers']/tbody/tr[2]/td[1]
 * //*[@id="customers"]/tbody/tr[2]/td[1] //*[@id="customers"]/tbody/tr[3]/td[1]
 * //*[@id="customers"]/tbody/tr[4]/td[1] //*[@id="customers"]/tbody/tr[5]/td[1]
 * //*[@id="customers"]/tbody/tr[6]/td[1] //*[@id="customers"]/tbody/tr[7]/td[1]
 * 
 * The pattern is table row (tr) keeps increasing by 1
 * 
 * 
 * String frontXpath = "//*[@id="customers"]/tbody/tr[" String backXpath =
 * "]/th[1]" for (int i = 1; i <= 7; i++) {
 * 
 * String wholeXpath = frontXpath + i + backXpath;
 * 
 * driver.findElement(By.xpath(wholeXpath)).getText();
 * 
 * }
 * 
 * 
 * 
 * @author RY
 *
 */

public class PrintRow {
	WebDriver driver;

	@BeforeClass // this will run only ones for the whole class
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//These two tests do same thing but the first one is dynamic.
	@Test
	public void rowsImprovedTest() {
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
		int rowsCount = rows.size();
		System.out.println("There are " + rowsCount + "rows");
		String frontXpath = "//*[@id='customers']/tbody/tr[";
		String backXpath = "]/td[1]";
		for (int i = 2; i <= rowsCount; i++) {
			String wholeXpath = frontXpath + i + backXpath;
			String rowText = driver.findElement(By.xpath(wholeXpath)).getText();
			System.out.println(rowText);

		}

	}

	@Test
	public void getRowsTest() {
		String frontXpath = "//*[@id='customers']/tbody/tr[";
		String backXpath = "]/td[1]";
		for (int i = 2; i <= 7; i++) {
			String wholeXpath = frontXpath + i + backXpath;
			String rowText = driver.findElement(By.xpath(wholeXpath)).getText();
			System.out.println(rowText);

		}

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
