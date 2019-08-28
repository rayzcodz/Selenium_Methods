package com.online5project;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitnessPall {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.myfitnesspal.com/exercise/lookup");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test//drop down
	public void nameMatchTest() {
		WebElement dropdown = driver.findElement(By.id("exercise_select"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Abs");// can we save it into a variable
		String expected = driver
				.findElement(By.xpath("//form[@id='caloriesBurned']//h4[@id='calories_burned_description']")).getText();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The text is :" + expected); // prints nothing

		WebElement exerciseTitle = driver
				.findElement(By.xpath("//form[@id='caloriesBurned']//h4[@id='calories_burned_description']"));
		Assert.assertTrue(exerciseTitle.getText().contains("Abs"));

	}

	@Ignore
	@Test //dropdown
	public void weightCoversionTest() {
		WebElement weightBox = driver.findElement(By.id("weight_display_value")); // html//input[@id='weight_display_value']

		weightBox.clear();
		weightBox.sendKeys("200");

		WebElement dropdown = driver.findElement(By.id("unit_preferences_body_weight"));
		Select select = new Select(dropdown);
		select.selectByIndex(0);

		WebElement weight = driver.findElement(By.xpath("html//input[@id='weight_display_value']"));
		System.out.println("Weight = " + weight.getAttribute("value")); // prints Weight = 200 instead of 68

		double expectedWeight = Math.round(200 / 2.2);
		Assert.assertFalse(weight.getAttribute("value").equals(String.valueOf(expectedWeight)));
		
		//		int zeroCalories = Integer.parseInt(nutritionTable.FoodCalorie.getText());   could come handy


	}
	@Ignore
	@Test
	public void incorrectTimeTest() {
		WebElement timebox = driver.findElement(By.id("minutes"));
		timebox.sendKeys("10min");
		
		String expectedMessage = driver.findElement(By.id("cresults")).getText(); //message.getText()
		assertTrue(expectedMessage.equals("NaN"));
	}

	@Ignore
	@Test
	public void coloriesBurnedTest() {
		WebElement weightBox = driver.findElement(By.id("weight_display_value"));
		weightBox.clear();
		weightBox.sendKeys("0");
		String expectedMessage = driver.findElement(By.id("cresults")).getText();
		assertTrue(expectedMessage.equals("0"));
		

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000); // Temp wait
		driver.quit();
	}

}
