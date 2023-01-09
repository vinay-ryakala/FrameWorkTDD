package IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ERP.mange.genric.BaseClass;
import com.ERP.mange.genric.GenrateTestData;
import com.ERP.mange.genric.ReadDataFromExcel;
import com.epr.manage.POM.AddProductsPage;
import com.epr.manage.POM.HomePage;

public class CreateProductAllTestCases2ndVersion extends BaseClass {

	public String editedProduct;

	@Test(groups = {"sanity"})
	public void createProductToProductList() throws EncryptedDocumentException, IOException, InterruptedException {

		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
		// GenrateTestData genrateTestData= new GenrateTestData();
		String createProduct = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 0);
		String productPrice = readDataFromExcel.readDataFromExcel("ProductDetails", 1, 1);
		String productUnit = readDataFromExcel.readDataFromExcel("ProductDetails", 1, 2);
		String productCat = readDataFromExcel.readDataFromExcel("ProductDetails", 1, 3);
		String productAvail = readDataFromExcel.readDataFromExcel("ProductDetails", 1, 4);

		HomePage hPage = new HomePage(driver);
		hPage.getAddProduct().click();
		AddProductsPage addProductsPage = new AddProductsPage(driver);
		addProductsPage.createProduct(createProduct, productPrice, productUnit, productCat, productAvail);
		wDriverUtil.acceptAlert();
		hPage.getProduct().click();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'" + createProduct + "')]")).getText();
		Assert.assertTrue(productName.equals(createProduct), productName + "is not found");
	}

//	@Test
//	public void checkProductInProductListOfManufacturer() throws IOException, InterruptedException {
//		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
//		String createProduct = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 0);
//		HomePage hPage = new HomePage(driver);
//		hPage.getProduct().click();
//		String productName = driver.findElement(By.xpath("//td[contains(text(),'" + createProduct + "')]")).getText();
//		Assert.assertTrue(productName.equals(createProduct), productName + "is not found");
//	}


	@Test(groups = {"sanity"})
	public void editProductInProductList() throws IOException, InterruptedException {

		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
		GenrateTestData testData = new GenrateTestData();
		String createProduct = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 0);
		 editedProduct = testData.productName();
		String editedPrice = testData.productPrice();
		HomePage hPage = new HomePage(driver);
		hPage.getProduct().click();
		driver.findElement(By.xpath("//td[contains(text(),'" + createProduct + "')]//following-sibling::td/a")).click();
		Thread.sleep(3000);
		AddProductsPage addProductsPage = new AddProductsPage(driver);
		addProductsPage.editProductName(editedProduct);
		addProductsPage.editProductPrice(editedPrice);
		addProductsPage.editStockManagement("enable");
		driver.findElement(By.xpath("//input[@value='Update Product']")).click();
		wDriverUtil.acceptAlert();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'" + editedProduct + "')]")).getText();
		readDataFromExcel.writeDataToExcel("ProductDetails", 2, 5, editedProduct);
		Assert.assertTrue(productName.equals(editedProduct), productName + "is not found");

	}
	@Test(groups = {"sanity"})
	public void deleteProductInProductList() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//td[contains(text(),' " + editedProduct + "')]//preceding-sibling::td/input"))
				.click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		driver.switchTo().alert().accept();
		try {
			String productName = driver.findElement(By.xpath("//td[contains(text(),'" + editedProduct + "')]"))
					.getText();
			Assert.assertFalse(productName.equals(editedProduct), productName + "is not found");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}

	}

	
}