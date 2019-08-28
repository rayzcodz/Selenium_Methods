package com.excelpractice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PrintAllSheetData {

	public static void main(String[] args) throws Exception {

		printAllSheetData();

		String[][] result = getAllSheetData("Book1.xlsx", "data"); //data is sheet name of Book1.xlsx
		System.out.println(Arrays.deepToString(result));
		
		getAllSheetData("Book1.xlsx", "data");
	}

	// Task 1
	// Create a utility method to store all sheetData
	// in two dimensional String Array
	// method name : getAllSheetData
	// return type : none
	// params : ()
	// logic , print everything in nice format

	public static void printAllSheetData() throws Exception {

		File excelFile = new File("Book1.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);

		Sheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < rowCount; i++) {

			System.out.println(" row number : " + i);

			for (int j = 0; j < colCount; j++) {

				Cell cell = sheet.getRow(i).getCell(j);
				System.out.print(cell.toString() + " | ");

			}
			System.out.println();

		}

		wb.close();

	}

	// Task 2
	// Create a utility method to store all sheetData
	// in two dimensional String Array
	// method name : getAllSheetData
	// return type : String[][]
	// params : FileName as String , SheetName

	public static String[][] getAllSheetData(String filePath, String SheetName) throws Exception {

		// File excelFile = new File("MOCK_DATA.xlsx") ;
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);

		// Sheet sheet = wb.getSheetAt(0);
		Sheet sheet = wb.getSheet(SheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();

		// String[][] data = new String[11][11] ;
		String[][] data = new String[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {

			// System.out.println(" row number : " + (i + 1));

			for (int j = 0; j < colCount; j++) {

				Cell cell = sheet.getRow(i).getCell(j);
				data[i][j] = cell.toString();
				// System.out.print(cell.toString() + " | ");

			}
			// System.out.println();

		}
		
		fis.close();
		wb.close();

		return data;

	}
	
	
	public static String getCellData(String filePath, String sheetName, int rowIndex, int colIndex) throws Exception{
		  
		  String[][] result = getAllSheetData(filePath, sheetName); 
		  return result[rowIndex][colIndex] ; 
		  
		}


}
