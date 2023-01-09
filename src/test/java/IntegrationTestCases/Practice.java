package IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import com.ERP.mange.genric.ReadDataFromExcel;

public class Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadDataFromExcel r= new ReadDataFromExcel();
		String cellValueString= r.readDataFromExcel("Sheet2", 2, 1);
		System.out.println(cellValueString);
		}
}
