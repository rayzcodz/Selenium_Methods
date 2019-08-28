package com.popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	@Test
	public void uploadTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get("https://html.com/input-type-file/");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@id='om-lightbox-postal-optin-wrap']/a")).click();
		driver.findElement(By.name("fileupload")).sendKeys("C:\\Users\\RY\\Desktop\\Automate\\Testfile.txt");

	}
}