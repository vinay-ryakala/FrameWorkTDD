package IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ERP.mange.genric.BaseClass;
import com.ERP.mange.genric.ReadDataFromExcel;
import com.epr.manage.POM.AddProductsPage;
import com.epr.manage.POM.HomePage;
@Listeners(com.ERP.mange.genric.ListenerImplimentation.class)
public class TC_01CreateProductAsAdminVerifyTest extends BaseClass {
	@Test(retryAnalyzer = com.ERP.mange.genric.RetryAnalyser.class)
	public void CreateProductToProductList() throws EncryptedDocumentException, IOException, InterruptedException {
				
		
		
		ReadDataFromExcel readDataFromExcel= new ReadDataFromExcel();
	//	GenrateTestData genrateTestData= new GenrateTestData();
		String createProduct = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 0);
		String productPrice = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 1);
		String productUnit = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 2);
		String productCat = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 3);
		String productAvail = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 4);
		
		HomePage hPage=new HomePage(driver);
		hPage.getAddProduct().click();
		AddProductsPage addProductsPage= new AddProductsPage(driver);
		addProductsPage.createProduct(createProduct, productPrice, productUnit, productCat, productAvail);
		wDriverUtil.acceptAlert();
		hPage.getProduct().click();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'" + createProduct + "')]")).getText()+"abcd";
		Assert.assertTrue(productName.equals(createProduct), productName + "is not found");

	}

}