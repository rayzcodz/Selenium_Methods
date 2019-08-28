package com.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
Bootstrap dropdowns cannot be handled using select class.
In order to click on bottstrap dropdown element
-first click on the box so that drop down menu displays
-find  all elements and loop thru
-if you find the element you need, click on it

 */

public class BootStrapDropdownClick {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Ignore
	@Test
	public void bootstrapDropdownTest() {
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();

		List<WebElement> elements = driver
				.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//li//a//label"));
		System.out.println(elements.size());

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().contains("Angular")) {
				elements.get(i).click();
				break;
			}
		}

	}

	@Ignore
	@Test // this method click all of them even thoug it is designed to click unselected
			// ones
	public void bootstrapDropdownSelectAllTest() {
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();

		List<WebElement> elements = driver
				.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//li//a//label"));
		System.out.println(elements.size());

		boolean isItSelected = true;

		for (int i = 0; i < elements.size(); i++) {
			isItSelected = elements.get(i).isSelected();

			if (!isItSelected) {
				elements.get(i).click();

			}
		}

	}
	
	@Test
	public void bootstrapDropdownSelectAllNewTest() {
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();

		List<WebElement> elements = driver
				.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//li//a//label"));
		System.out.println(elements.size());
		
		for (int i = 0; i < elements.size(); i++) {
			if (!(elements.get(i).getText().contains("HTML")) || (elements.get(i).getText().contains("CSS"))) {
				elements.get(i).click();
			}
		}
	}

}
