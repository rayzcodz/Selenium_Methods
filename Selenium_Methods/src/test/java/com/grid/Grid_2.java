package com.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Grid_2 { //followed instructions on: https://www.guru99.com/introduction-to-selenium-grid.html

	WebDriver driver;
	String baseUrl, nodeUrl;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\RY\\Documents\\selenium dependencies\\drivers\\geckodriver.exe");

		baseUrl = "http://newtours.demaut.com/";
		nodeUrl = "http://192.168.1.119:4444/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.ANY);
		driver = new RemoteWebDriver(new URL(nodeUrl), capability);

	}
	
	
	@Test
	public void titleTest() {
		driver.get(baseUrl);
		Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
	}

}
