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

public class TC_03DeleteProductAsAdminVerifyTest {
	String createProduct;
	WebDriver driver;
	String url, adminUserName, adminPwd, manufacturerUserName, manufacturerPwd;
	WebDriverUtil wDriverUtil;

	@BeforeTest
	public void loadCreadtialsFromPropertiesFile() throws IOException {
		ReadDataFromPropertiesFiles readDataFromFiles = new ReadDataFromPropertiesFiles();
		url = readDataFromFiles.readDataFromPropertiesFile("url");
		adminUserName = readDataFromFiles.readDataFromPropertiesFile("username");
		adminPwd = readDataFromFiles.readDataFromPropertiesFile("password");

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
		loginPage.login(adminUserName, adminPwd, "admin");
	}

	@Test
	public void deleteProductInProductList() throws IOException, InterruptedException {
		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
		createProduct = readDataFromExcel.readDataFromExcel("ProductDetails", 2, 0);
		HomePage hPage= new HomePage(driver);
		hPage.getProduct().click();
		driver.findElement(By.xpath("//td[contains(text(),' " + createProduct + "')]//preceding-sibling::td/input"))
				.click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		wDriverUtil.acceptAlert();
		try {
			String productName = driver.findElement(By.xpath("//td[contains(text(),'" + createProduct + "')]"))
					.getText();
			Assert.assertFalse(productName.equals(createProduct), productName + "is not found");
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
