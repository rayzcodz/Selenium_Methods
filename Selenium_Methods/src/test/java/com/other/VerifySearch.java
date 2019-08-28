package com.other;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*TC 1: Verify Search term.
 * 1.Open browser
 * 2.Open Etsy homepage
 * 3.Enter search term
 * 4.Verify the results page title contains the search term
 * 5.Verify search entry is still saved in the search bar
 * 
 */

public class VerifySearch {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		String searchItem = "fathers' day gift";
		WebElement input = driver.findElement(By.id("search-query"));		
		//click search button using keyboard. because html code was not allowing to find it
		input.sendKeys(searchItem + Keys.ENTER); //previous page is gone
		
		
		
		//locate the element again
		input = driver.findElement(By.id("search-query"));
		//Step 5. get the text of the element
		String actual = input.getAttribute("value");
		
		System.out.println(actual);
		
		if (actual.equals(searchItem)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
			System.out.println("Expected:\t" + searchItem);
			System.out.println("Found:\t"+ actual);
		}
		
		
		
		
		
	}

}
