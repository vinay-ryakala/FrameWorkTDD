package com.ERP.DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadFromExcel {
	@Test
	public void readFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream("./Data/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
	}

	@Test
	public void readAllDataFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream("./Data/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastActiveRow = sheet.getLastRowNum();
		int lastActiveCell = sheet.getRow(1).getLastCellNum();
		for (int i = 0; i <= lastActiveRow; i++) {
			for (int j = 0; j < lastActiveCell; j++) {
				
				if(sheet.getRow(i).getCell(j).getCellType().equals("String")) {
					String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				}else {
					String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				}
				
				
			}
			System.out.println();
		}
	}
}
