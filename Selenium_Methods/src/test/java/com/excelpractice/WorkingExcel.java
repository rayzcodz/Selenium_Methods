package com.excelpractice;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WorkingExcel {

	public static void main(String[] args) throws Exception {

		// Workbook --> Sheet ---> Row--> Cell

		// Eealier version of poi library
		// have 2 different set of classes to work with xls , xlsx files
		/*
		 * xls files --- MS Excel 97-2003 HSSFWorkbook , HSSFSheet , HSSFRow , HSSFCell
		 * xlsx XSSFWorkbook , XSSFSheet , XSSFRow , XSSFCell
		 */

		File excelFile = new File("Book1.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);

		System.out.println(wb.getNumberOfSheets());

		// Sheet sh = wb.getSheet("data");
		Sheet sh = wb.getSheetAt(0);
		Row row1 = sh.getRow(0);
		Cell c1 = row1.getCell(1);
		System.out.println(c1);

		int columnCountInFirstRow = row1.getLastCellNum();

		System.out.println(columnCountInFirstRow);

		// int rowCount = sh.getLastRowNum();
		// System.out.println( rowCount );

		// getPhysicalNumberOfRows will return actual rowNumber
		// whether you have empty value row or not
		int actualRowCount = sh.getPhysicalNumberOfRows();
		System.out.println(actualRowCount);

		for (int i = 0; i < actualRowCount; i++) {
			System.out.println("ROW NUMBER : " + (i + 1));

			Row row = sh.getRow(i);

			for (int j = 0; j < columnCountInFirstRow; j++) {

				Cell cell = row.getCell(j);
				System.out.print(cell + "---");

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
	// params  :  FileName as String , SheetName 
	
	
	
	
	
	
	
	
  }

