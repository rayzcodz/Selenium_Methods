package com.popups;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		String url = "https://mail.rediff.com/cgi-bin/login.cgi";
		driver.get(url);
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(4000);
		Alert popup = driver.switchTo().alert();
	
		String popupText = popup.getText();
		
		if (popupText.equals("Please enter a valid user name")) {
			System.out.println("Valid pop-up");
		}
		
		else {
			System.out.println("Invalid pop-up");
		}
		
		
		popup.accept();
	


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
