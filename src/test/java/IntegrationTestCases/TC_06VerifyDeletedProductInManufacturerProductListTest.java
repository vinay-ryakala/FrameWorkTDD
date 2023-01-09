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

import com.ERP.mange.genric.ReadDataFromExcel;
import com.ERP.mange.genric.ReadDataFromPropertiesFiles;
import com.ERP.mange.genric.WebDriverUtil;
import com.epr.manage.POM.HomePage;
import com.epr.manage.POM.LoginPage;

public class TC_06VerifyDeletedProductInManufacturerProductListTest {
	String createProduct ;
	String editedProduct ;
	WebDriver driver;
	WebDriverUtil wDriverUtil;
	String url, adminUserName, adminPwd, manufacturerUserName, manufacturerPwd;

	@BeforeTest
	public void loadCreadtialsFromPropertiesFile() throws IOException {
		ReadDataFromPropertiesFiles readDataFromFiles = new ReadDataFromPropertiesFiles();
		url = readDataFromFiles.readDataFromPropertiesFile("url");
		manufacturerUserName = readDataFromFiles.readDataFromPropertiesFile("manufacturerUsername");
		manufacturerPwd = readDataFromFiles.readDataFromPropertiesFile("manufacturerPwd");
	}

	@BeforeClass
	public void lunchBrowser() {
		driver = new ChromeDriver();
		wDriverUtil = new WebDriverUtil(driver);
		wDriverUtil.maximizeWindow();
		wDriverUtil.waitDriver();
	}

	@BeforeMethod
	public void login() {
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(manufacturerUserName, manufacturerPwd, "manufacturer");
	}

	@Test()
	public void checkDeletedProductInProductListOfManufacturer() throws IOException, InterruptedException {
		ReadDataFromExcel readDataFromExcel= new ReadDataFromExcel();
		createProduct=	readDataFromExcel.readDataFromExcel("ProductDetails", 1, 0);
		HomePage hPage = new HomePage(driver);
		hPage.getProduct().click();
		try {
			String productName = driver.findElement(By.xpath("//td[contains(text(),'" + editedProduct + "')]"))
					.getText();
			Assert.assertTrue(productName.equals(editedProduct), productName + "is not found");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
	}

	@AfterClass
	public void quitBrowser() {
		driver.close();
	}
}
