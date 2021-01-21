package com.target.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	private static Workbook book;
	private static Sheet sheet;
	public static FileInputStream fis;
	
	public static void openExcel(String filePath)  {
		
		try {
		    fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static void loadSheet(String sheetName) {
		sheet=book.getSheet(sheetName );
	}
	
	public  static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colsCount(int rowIndex) {
		
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	public static List<Map<String, String>> excelIntoListOfmaps(String filePath, String sheetName){
		openExcel(filePath);
		loadSheet(sheetName);
		
	    List<Map<String, String>> listOfMaps = new ArrayList<>();		
		Map<String, String> excelMap;
		
		for (int row = 1; row < rowCount(); row++) {
			excelMap = new LinkedHashMap<>();
			for (int col=0; col<colsCount(row); col++) {
				String key=cellData(0, col);
				String value=cellData(row, col);
				excelMap.put(key, value);
				
			}
			listOfMaps.add(excelMap);
		}
	       
		return listOfMaps;
	}

	

}
