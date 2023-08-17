package com.Pratice.java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int last = sh.getLastRowNum();
		for (int i = 0; i < last; i++) {
			String UN = sh.getRow(i).getCell(0).getStringCellValue();
			String PWD = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(UN + "--->" + PWD);

		}
		wb.close();
	}

}
