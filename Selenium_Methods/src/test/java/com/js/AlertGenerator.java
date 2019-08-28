package com.js;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertGenerator {
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
	public void drawBorder() {
		// Highlight login/sigin button
		driver.get("https://www.bankofamerica.com/");
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='signIn']"));
		drawBorder(loginBtn, driver);

	}

	@Test
	public void takeScreenShotTest() throws IOException {
		// Takes screen shot and saves as file format
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now copy the screen shot to a desider location using copyFile() method
		FileUtils.copyFile(screenShot, new File(
				"C:\\Users\\RY\\eclipse-workspace\\yumukhov-automation\\src\\test\\java\\com\\js\\BOAalert.png"));

		generateAlert(driver, "There is a issue with \"Sign in\" button on Login page!");
	}

	// This method draws border around an element as name suggests
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '5px solid green' ", element);

	}

	// This method generates alert with message
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

}
