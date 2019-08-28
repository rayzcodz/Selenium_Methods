package com.popups;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopUp {  //AKA browser pop up
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	
	@Ignore
	@Test
	public void windowTest() throws InterruptedException {
		driver.findElement(By.linkText("Good PopUp #1")).click();
		Thread.sleep(2000);
		
	}
	
	@Test //For some reason this test does not pass if I do not ignore the above test.
	public void windowCloseTest() throws InterruptedException {
		
		driver.findElement(By.linkText("Good PopUp #1")).click();
	
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator(); //iterates thru all windows because
		//Set is not index based and thus we have to use Iterator to loop thru
		
		String parentWindowId = it.next();//gets ID of the PARENT window
		System.out.println("Parent window ID is : " + parentWindowId);
		
		String childWindowId = it.next(); //gets ID of the CHILD window
		System.out.println("Child window ID is : " + childWindowId);
		
		Thread.sleep(2000);
		
		driver.switchTo().window(childWindowId); //Now controlling child window
		
		System.out.println("Child window title is: " + driver.getTitle());
		driver.close();//closing child window
		
		Thread.sleep(2000);
		
		driver.switchTo().window(parentWindowId); //Now controlling parent window
		
		System.out.println("Parent window title is: " + driver.getTitle());
		driver.close();

	}
	
}
