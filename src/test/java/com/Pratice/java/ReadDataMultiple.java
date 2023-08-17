package com.Pratice.java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataMultiple {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int row = sh.getLastRowNum();
		for (int i = 1; i < sh.getLastRowNum(); i++) {
			String orgName = sh.getRow(i).getCell(0).getStringCellValue();
			String loc = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(orgName + "--->" + loc);

		}

	}

}
