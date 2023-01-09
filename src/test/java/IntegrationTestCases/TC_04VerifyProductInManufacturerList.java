package IntegrationTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ERP.mange.genric.BaseClassManufacturer;
import com.ERP.mange.genric.ReadDataFromExcel;
import com.epr.manage.POM.HomePageManufacturer;

public class TC_04VerifyProductInManufacturerList extends BaseClassManufacturer{
	@Test
	public void checkProductInProductListOfManufacturer() throws IOException, InterruptedException {
		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
		String createProduct = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 0);
		HomePageManufacturer hPage = new HomePageManufacturer(driver);
		Thread.sleep(3000);
		hPage.getProduct().click();
		Thread.sleep(3000);
		String productName = driver.findElement(By.xpath("//td[contains(text(),'" + createProduct + "')]")).getText();
		Assert.assertEquals(productName,createProduct);
	}
}
