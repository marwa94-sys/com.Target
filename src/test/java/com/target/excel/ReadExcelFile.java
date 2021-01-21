package com.target.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.target.utils.ExcelUtility;

public class ReadExcelFile extends ExcelUtility {
	
	
	
	public static void main(String[] args) throws IOException {
	String filePath="C://Users//marwa//eclipse-workspace//com.target.MavenCucumber//src//test//resources//testData//testdata02.xlsx";
	
	FileInputStream fis= new FileInputStream(filePath);
	
	Workbook WBook= new XSSFWorkbook(fis);
	
	Sheet sheet= WBook.getSheet("Sheet1");
	
	Row row=sheet.getRow(1);
 
	Cell cell= row.getCell(1);
	
   String cell1row2=cell.toString();
	System.out.println(cell1row2);	
		
		
		
		
		
		
		
		System.out.println(excelIntoListOfmaps("C://Users//marwa//eclipse-workspace//com.target.MavenCucumber//src//test//resources//testData//testdata02.xlsx", "Sheet1"));
		
		
		
		
		
		
		
		
		
		
		
	}
}
