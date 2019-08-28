package com.other;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {
	// https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/");
		
		//1. find select tag
		
		
		WebElement selectTag = driver.findElement(By.name("my_html_select_box"));
		
		//2. create select object from select tag
		Select list = new Select(selectTag);
		
		//return selected element
		//print selected value Option 1:
		WebElement selected = list.getFirstSelectedOption();
		System.out.println(selected.getText());
		
		
		//option 2
		System.out.println(list.getFirstSelectedOption().getText());
		
		//print all available options. selected or not 
		List<WebElement> options = list.getOptions();
		System.out.println("------------------------------");
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
		
		System.out.println("--------------------------------");
		//select using visible text
		list.selectByVisibleText("Bucharest");
		System.out.println("Selected:\t" + list.getFirstSelectedOption().getText());
		
		//select using index
		list.selectByIndex(0);
		System.out.println("Selected:\t" + list.getFirstSelectedOption().getText());
		
		System.out.println("***********************************");
		Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes']")));
		secondList.selectByVisibleText("New York");
		secondList.selectByVisibleText("Madrid");
		
		
		List<WebElement> allselectedoptions = secondList.getAllSelectedOptions();
		for (WebElement webElement : allselectedoptions) {
			System.out.println(webElement.getText());
		}
		
		System.out.println(allselectedoptions.size());
		secondList.deselectAll();
		allselectedoptions = secondList.getAllSelectedOptions();
		System.out.println(allselectedoptions.size());
		
	}

}
