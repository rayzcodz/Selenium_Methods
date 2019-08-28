package com.frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YoutubeFrame {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void clickOnMainVideoTest() { //this is the biger sized video on youtube.
		int size = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			int total = driver.findElements(By.id("video-masthead")).size();
			System.out.println(total);
			driver.switchTo().defaultContent(); // switching back from the iframe
		}
		driver.switchTo().frame(1);
		driver.findElement(By
				.xpath("//iframe[@id='player' and @class='style-scope ytd-video-masthead-ad-primary-video-renderer']"))
				.click();
		/// clickOn(driver, driver.findElement(By.xpath("//*[@id='click-target']")),
		// 20);
	}

	//try again

}
