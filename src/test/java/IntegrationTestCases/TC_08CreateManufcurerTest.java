package IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ERP.mange.genric.BaseClass;
import com.ERP.mange.genric.ReadDataFromExcel;
import com.epr.manage.POM.AddManufacturerPage;
import com.epr.manage.POM.HomePage;

import junit.framework.Assert;

public class TC_08CreateManufcurerTest extends BaseClass {
	@Test(dataProvider = "providesData")
	public void createManufacturerAsAdminAndVerify(String name,String email,String phone,String Uname,String Pwd) throws EncryptedDocumentException, IOException {
		HomePage hPage = new HomePage(driver);
		hPage.getAddManufacturer().click();
		AddManufacturerPage addManufacturerPage= new AddManufacturerPage(driver);
		//ReadDataFromExcel rDataFromExcel= new ReadDataFromExcel();
		//String[] manuFacDetails=rDataFromExcel.readDataFromExcel("Sheet1", 1);
		addManufacturerPage.createNewManufacturer(name,email,phone,Uname,Pwd);
		hPage.getManufacturer().click();
		String manufacturerName = driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]")).getText();
		Assert.assertEquals(name, manufacturerName);
	}
	@DataProvider
	public String[][] providesData() throws EncryptedDocumentException, IOException{
		String[][] manuFacDetails=new String[5][5];
		ReadDataFromExcel rDataFromExcel= new ReadDataFromExcel();
		
		for (int i = 0; i < manuFacDetails.length; i++) {
			manuFacDetails[i]=rDataFromExcel.readDataFromExcel("Sheet1", i);
		}
		return manuFacDetails;
	}
}
