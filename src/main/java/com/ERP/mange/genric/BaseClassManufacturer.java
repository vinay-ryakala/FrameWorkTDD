package com.ERP.mange.genric;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.epr.manage.POM.LoginPage;

public class BaseClassManufacturer extends BaseClass {

	@BeforeMethod
	public void login() throws IOException {
		ReadDataFromPropertiesFiles readDataFromFiles = new ReadDataFromPropertiesFiles();
		String url = readDataFromFiles.readDataFromPropertiesFile("url");		
		String adminUserName = readDataFromFiles.readDataFromPropertiesFile("manufacturerUsername");
		String adminPwd = readDataFromFiles.readDataFromPropertiesFile("manufacturerPwd");
		driver.get(url);
		wDriverUtil.waitDriver();
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login(adminUserName, adminPwd, "manufacturer");
	}
}
