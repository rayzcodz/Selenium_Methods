package com.excelpractice;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {

  public static void main(String[] args) throws Exception {
    
    
    File excelFile = new File("Book1.xlsx") ; 
    Workbook wb = WorkbookFactory.create(excelFile);
    
    System.out.println(wb.getNumberOfSheets() );   
    
    //Sheet sh = wb.getSheet("data");
    Sheet sh = wb.getSheetAt(0); 
    Row row1 = sh.getRow(1) ; 
    Cell c1 =  row1.getCell(1) ; 
    System.out.println( c1 );
    
    c1.setCellValue("MY OWN VALUE");
    
    FileOutputStream fos = new FileOutputStream("myown.xlsx"); 
    
    wb.write(fos);
    fos.close();
    wb.close();
    
  }

}