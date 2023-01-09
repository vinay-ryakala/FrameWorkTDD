package com.ERP.mange.genric;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.epr.manage.POM.HomePage;
import com.epr.manage.POM.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public WebDriverUtil wDriverUtil;
	//@Parameters("browser")
	@BeforeClass(groups = {"sanity"})
	public void openBrowser()  {
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else {
//			driver = new FirefoxDriver();
//		}
		driver = new ChromeDriver();
		sdriver=driver;
		wDriverUtil= new WebDriverUtil(driver);
		wDriverUtil.maximizeWindow();
		
	}

	@BeforeMethod(groups = {"sanity"})
	public void login() throws IOException {
		ReadDataFromPropertiesFiles readDataFromFiles = new ReadDataFromPropertiesFiles();
		String url = readDataFromFiles.readDataFromPropertiesFile("url");		
		String adminUserName = readDataFromFiles.readDataFromPropertiesFile("username");
		String adminPwd = readDataFromFiles.readDataFromPropertiesFile("password");
		driver.get(url);
		wDriverUtil.waitDriver();
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login(adminUserName, adminPwd, "admin");

	}
	@AfterMethod(groups = {"sanity"})
	public void logout() {
		HomePage hPage = new HomePage(driver);
		hPage.getLogOut().click();
	}

	@AfterClass(groups = {"sanity"})
	public void closeBrowser() {
		driver.close();
	}
	
}
