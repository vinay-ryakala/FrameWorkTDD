 package com.ERP.mange.genric;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public String readDataFromExcel(String sheetNum, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream(IAutoConstants.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetNum);
		String cellValue;
		DataFormatter dFormatter = new DataFormatter();
		cellValue = dFormatter.formatCellValue(sheet.getRow(row).getCell(cell));
		fileInputStream.close();
		return cellValue;
		
	}
	
	public void writeDataToExcel(String sheetNum, int row, int cell, String value) throws EncryptedDocumentException, IOException {
	FileInputStream fileInputStream = new FileInputStream(IAutoConstants.EXCELPATH);
	Workbook workbook=	WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetNum);
	if (sheet.getRow(row)!=null) {
		sheet.getRow(row).createCell(cell).setCellValue(value);
	}else {
		sheet.createRow(row).createCell(cell).setCellValue(value);
	}
	
	FileOutputStream fileOutputStream = new FileOutputStream("./Data/TestData.xlsx");
	workbook.write(fileOutputStream);  
	fileInputStream.close();
	fileOutputStream.close();
	}

	public String[] readDataFromExcel(String sheetNum, int row) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(IAutoConstants.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetNum);
		int lastActiveCell = sheet.getRow(row).getLastCellNum();
		System.out.println(lastActiveCell);
		String[] manuFactDetail=new String[lastActiveCell];
		DataFormatter dFormatter = new DataFormatter();
		for (int j = 0; j < lastActiveCell; j++) {
			manuFactDetail[j] = dFormatter.formatCellValue(sheet.getRow(row).getCell(j));
		}
		fileInputStream.close();
		return manuFactDetail;
		
	
		
	}
}
