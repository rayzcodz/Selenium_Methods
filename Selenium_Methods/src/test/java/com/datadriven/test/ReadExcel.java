//package com.datadriven.test;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.excel.utility.Xls_Reader;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
////This class only reads data from excel file.
////it does not parapetrize
//public class ReadExcel {
//
//	WebDriver driver;
//
//	@BeforeClass
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
//	public void fillRegForm() {
//		Xls_Reader reader = new Xls_Reader(
//				"C:\\Users\\RY\\eclipse-workspace\\AAA-automation\\src\\test\\java\\com\\testdata\\EbayRegTestData.xlsx");
//		// read data using the below ut method
//		// str str int
//		// reader.getCellData(sheetName, colNum, rowNum)
//		int rowCount = reader.getRowCount("RegTestData");
//		System.out.println(rowCount);
//		
//		
//		String firstname = reader.getCellData("RegTestData", "firstname", 2);
//		System.out.println(firstname);
//
//		String lastname = reader.getCellData("RegTestData", "lastname", 2);
//		System.out.println(lastname);
//
//		String emailaddress = reader.getCellData("RegTestData", "emailaddress", 2);
//		System.out.println(emailaddress);
//
//		String password = reader.getCellData("RegTestData", "password", 2);
//		System.out.println(password);
//
//		driver.findElement(By.id("firstname")).sendKeys(firstname);
//		driver.findElement(By.id("lastname")).sendKeys(lastname);
//		driver.findElement(By.id("email")).sendKeys(emailaddress);
//		driver.findElement(By.id("PASSWORD")).sendKeys(password);
//		
//	
//	
//	
//	}
//
//}
