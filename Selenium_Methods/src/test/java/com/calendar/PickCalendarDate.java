package com.calendar;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * How to handle calendar using Selenium
 * 1. Use dynamic table xpath concept
 * 2. Loop thru columns and rows
 * 3. 
 */

public class PickCalendarDate {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void loginTest() {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("yumukhov");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123456");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

	}

	@Test(priority = 2)
	public void pickCalendarDate() {
		driver.switchTo().frame("mainpanel");
		String date = "1-May-2017";
		String[] dateArr = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		// Lets select month and year (we will use another method to pick date later)
		Select select1 = new Select(driver.findElement(By.name("slctMonth")));
		select1.selectByVisibleText("May");

		Select select2 = new Select(driver.findElement(By.name("slctYear")));
		select2.selectByVisibleText("2005");

		// Now picking date which is harder one

		// lets get xpath of dates to see the pattern

		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[5]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[6]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[7]
		// ...
		// ...
		// ...
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[6]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[7]
		// ...
		// ...
		// ...
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[6]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[7]

		// breaked up version

		// "*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[" 7 "]/td[" 7]

		String beforeXpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";

		final int totalWeekDays = 7;

		boolean flag = false;
		String dayVal = null;
		for (int rowNum = 2; rowNum <= 7; rowNum++) {

			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {
				try {
					dayVal = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).getText();
				} catch (NoSuchElementException e) {
					System.out.println("Please enter a correct date value");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if (dayVal.equals(day)) {
					driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).click();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}

		}

	}

}
