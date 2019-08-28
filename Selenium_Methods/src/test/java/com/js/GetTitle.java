package com.js;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Watch the video if needed.
 * https://www.youtube.com/watch?v=Rjs9qLRP9tM&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=18
 */


public class GetTitle {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void refreshBrowserTest() {
		driver.get("https://www.bestbuy.com/");
		// refresh using selenium
		// driver.navigate().refresh();
		// refresh using JS
		getTitle(driver);
	}

	public static String getTitle(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

}
