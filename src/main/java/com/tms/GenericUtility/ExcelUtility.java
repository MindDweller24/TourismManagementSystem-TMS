package com.tms.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	public String getTestData(String sheetName, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;

	}

	public int getLastRowNumber(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;

	}

	public void setExcelData(String sheetName, int row, int cell, String value) throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelPATH);
		wb.write(fos);
		wb.close();
	}

	public HashMap<String, String> getMultipleExcelData(String sheetName, int keyCelNo, int valueCelNo,
			WebDriver driver) throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();

		HashMap<String, String> hs = new HashMap<String, String>();
		for (int i = 0; i < count; i++) {
			String key = sh.getRow(i).getCell(keyCelNo).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCelNo).getStringCellValue();
			hs.put(key, value);
		}
		return hs;

	}

	public Object[][] getExcelDataDP(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum() + 1;
		short lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

	public Object[][] getExcelDataDPTms(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum() + 1;
		short lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
