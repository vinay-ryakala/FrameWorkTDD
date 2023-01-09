package com.ERP.DDT;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ERP.mange.genric.GenrateTestData;
import com.ERP.mange.genric.ReadDataFromExcel;

public class WriteToExcelManuFacDetails {
	@Test
	public void writeToExcel() throws EncryptedDocumentException, IOException {
		ReadDataFromExcel writeExcel = new ReadDataFromExcel();
		String[] a = new String[5];
		GenrateTestData r = new GenrateTestData();
		for (int i = 0; i < 5; i++) {
			a[0] = r.firstName();
			a[1] = r.email();
			a[2] = r.phoneNumber();
			a[3] = a[0]+ "001";
			a[4] = "123456789";

			;
			for (int j = 0; j < 5; j++) {
				writeExcel.writeDataToExcel("Sheet1", i, j, a[j]);
			}

		}

	}
}
