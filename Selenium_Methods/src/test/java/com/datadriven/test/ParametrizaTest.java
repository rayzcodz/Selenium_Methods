//package com.datadriven.test;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.excel.utility.Xls_Reader;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class ParametrizaTest {
//
//	WebDriver driver;
//
//	@BeforeMethod
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@Test
//	public void readMoreExcelDataTest() {
//		Xls_Reader reader = new Xls_Reader(
//				"C:\\Users\\RY\\eclipse-workspace\\AAA-automation\\src\\test\\java\\com\\testdata\\EbayRegTestData.xlsx");
//		int rowCount = reader.getRowCount("RegTestData");
//		System.out.println("Row count is " + rowCount);
//
//		// Xls_Reader reader = new Xls_Reader(
//		// "C:\\Users\\RY\\eclipse-workspace\\AAA-automation\\src\\test\\java\\com\\testdata\\EbayRegTestData.xlsx");
//		// read data using the below ut method
//		// str str int
//		// reader.getCellData(sheetName, colNum, rowNum)
//		// int rowCount = reader.getRowCount("RegTestData");
//		// System.out.println(rowCount);
//
//		// parametrization
//		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
//			String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
//			System.out.println(firstname);
//
//			String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
//			System.out.println(lastname);
//
//			String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
//			System.out.println(emailaddress);
//
//			String password = reader.getCellData("RegTestData", "password", rowNum);
//			System.out.println(password);
//
//			// enter data
//			driver.findElement(By.id("firstname")).clear();
//			driver.findElement(By.id("firstname")).sendKeys(firstname);
//
//			driver.findElement(By.id("lastname")).clear();
//			driver.findElement(By.id("lastname")).sendKeys(lastname);
//
//			driver.findElement(By.id("email")).clear();
//			driver.findElement(By.id("email")).sendKeys(emailaddress);
//
//			driver.findElement(By.id("PASSWORD")).clear();
//			driver.findElement(By.id("PASSWORD")).sendKeys(password);
//
//		}
//
//	}
//
//}
