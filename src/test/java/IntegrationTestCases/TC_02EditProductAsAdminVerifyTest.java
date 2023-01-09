package IntegrationTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ERP.mange.genric.BaseClass;
import com.ERP.mange.genric.GenrateTestData;
import com.ERP.mange.genric.ReadDataFromExcel;
import com.ERP.mange.genric.ReadDataFromPropertiesFiles;
import com.ERP.mange.genric.WebDriverUtil;
import com.epr.manage.POM.AddProductsPage;
import com.epr.manage.POM.HomePage;
import com.epr.manage.POM.LoginPage;

public class TC_02EditProductAsAdminVerifyTest extends BaseClass{
	

	@Test()
	public void editProductInProductList() throws IOException, InterruptedException {
		
		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
		GenrateTestData testData = new GenrateTestData();
		String createProduct = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 0);
		String editedProduct = testData.productName();
		String editedPrice = testData.productPrice();
		HomePage hPage= new HomePage(driver);
		hPage.getProduct().click();
		driver.findElement(By.xpath("//td[contains(text(),'" + createProduct + "')]//following-sibling::td/a")).click();
		Thread.sleep(3000);
		AddProductsPage addProductsPage= new AddProductsPage(driver);
		addProductsPage.editProductName(editedProduct);
		addProductsPage.editProductPrice(editedPrice);
		addProductsPage.editStockManagement("enable");
		driver.findElement(By.xpath("//input[@value='Update Product']")).click();
		wDriverUtil.acceptAlert();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'" + editedProduct + "')]")).getText();
		readDataFromExcel.writeDataToExcel("ProductDetails", 2, 5,editedProduct);
		Assert.assertTrue(productName.equals(editedProduct), productName + "is not found");

	}

	
}
