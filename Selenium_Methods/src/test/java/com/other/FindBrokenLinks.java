package com.other;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinks {

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
	public void linkTest() throws MalformedURLException, IOException {
		driver.switchTo().frame("mainpanel");

		// 1. get the list of all the a-tag links and img-tag links
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img"))); // adding image links to a-tag links

		System.out.println("Total count of links = " + linkList.size());

		// 2. iterate linkList and exlclude all a-tag links and img-tag links
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for (int i = 0; i < linkList.size(); i++) {
			if (linkList.get(i).getAttribute("href") != null
					&& (!linkList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linkList.get(i));
			}

		}

		// 3. check the href url, with HttpURLConnection api
		for (int i = 0; i < activeLinks.size(); i++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(i).getAttribute("href"))
					.openConnection();
			connection.connect(); //it kinda works but says there is an error on this line
			String responce = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(i).getAttribute("href") + "-----> " + responce);
			
			
			
			
		}

	}

}
