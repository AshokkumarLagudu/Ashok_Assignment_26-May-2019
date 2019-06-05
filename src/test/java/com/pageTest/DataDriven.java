package com.pageTest;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ashok.util.Xls_Reader;



public class DataDriven {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static String cell;
	private static XSSFRow row;
	private static FileInputStream ExcelFile;
	static Xls_Reader xldata;
	private static Logger log=LogManager.getLogger(DataDriven.class.getName());
	@Test(dataProvider="data")
	public void printData(String key,String value) {

		log.info("geting key is: "+key);
		log.info("geting value is: "+value);
		log.info("============================");
				
				
			

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
}
