package com.other;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorExample {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		
		//WebElement input = driver.findElement(By.id("search-query"));
		//System.out.println(input.getAttribute("innerHTML"));
		//System.out.println(input.getAttribute("outerHTML"));
		//both lines below click on the "Sell on Etsy" text link
		//driver.findElement(By.linkText("Sell oN Etsy")).click();
		driver.findElement(By.partialLinkText("Sell oN")).click();
		

	}

}
