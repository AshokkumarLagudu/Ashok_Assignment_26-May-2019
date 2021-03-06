package com.ashok.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Read_XL_Data {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static String cell;
	private static XSSFRow row;
	private static FileInputStream ExcelFile;
	static Xls_Reader xldata;

	@Test(dataProvider="data")
	public void printData(String key,String value) {

		
				
				System.out.println(key+"---> "+value);
				
			

	}

	@DataProvider(name = "data")
	public Object[][] userdata() {
		Object[][] d = getTableData("C://Users//ASHOK//Desktop//PeoplesData.xlsx", "AddPerson");
		return d;
	}

	public static Object[][] getTableData(String filePath, String sheetName) {
		String[][] tabArray = null;
		String key = "";
		String value = "";
		
		Xls_Reader xldata = new Xls_Reader(filePath);

		int maxRows = xldata.getRowCount(sheetName)+1;
		int maxCol = xldata.getColumnCount(sheetName);
		System.out.println("maxRows = " + maxRows);
		System.out.println("maxCol = " + maxCol);
		tabArray = new String[(maxRows - 1)*(maxCol-1)][2];

		int col=1;
		int r=0;
		while(col<maxCol){
			for(int i=1;i<maxRows;i++){
				
					
						key = xldata.getCellData(sheetName, 0, i);
						tabArray[r][0]=key;

						value = xldata.getCellData(sheetName, col, i);
						tabArray[r][1]=value;
						
				r++;
				
			}
			
			col++;
		}
		return tabArray;

	}

	/*
	 * private static String getCellData(int rowNum, int cellNum) {
	 * 
	 * // cell = sheet.getRow(rowNum).getCell(cellNum); cell =
	 * xldata.getCellData("AddPerson", cellNum, rowNum); // String
	 * sdt=cell.getStringCellValue(); System.out.println(cell);
	 * 
	 * return cell; }
	 */

}

/*
 * Object[][] tabArray = null;
 * 
 * try { ExcelFile = new FileInputStream(filePath); workbook = new
 * XSSFWorkbook(ExcelFile);
 * 
 * } catch (FileNotFoundException e) {
 * System.out.println("Please provide correct XLfile path");
 * e.printStackTrace(); } catch (IOException e) {
 * 
 * e.printStackTrace(); }
 * 
 * xldata = new Xls_Reader("C://Users//ASHOK//Desktop//PeoplesData.xlsx");
 * 
 * sheet = workbook.getSheet(sheetName); int maxRows = sheet.getLastRowNum();
 * int maxCol = 2; // row.getPhysicalNumberOfCells();
 * 
 * 
 * tabArray = new Object[maxRows][maxCol];
 * 
 * for (int i = 1; i < maxRows; i++) {
 * 
 * for (int j = 0; j < maxCol; j++) { if (j == 0) {
 * 
 * tabArray[i][j] = xldata.getCellData(sheetName, j, i);; } else {
 * 
 * tabArray[i][j] = xldata.getCellData(sheetName, j, i); }
 * 
 * } }
 * 
 * return tabArray;
 * 
 */