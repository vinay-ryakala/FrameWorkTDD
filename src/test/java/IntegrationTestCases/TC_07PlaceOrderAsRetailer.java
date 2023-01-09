package IntegrationTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.ERP.mange.genric.ReadDataFromPropertiesFiles;
import com.ERP.mange.genric.WebDriverUtil;
import com.epr.manage.POM.LoginPage;

public class TC_07PlaceOrderAsRetailer {
	WebDriver driver;
	String url, retailerUserName,retailerPwd;
	WebDriverUtil wDriverUtil;


	@Test
	public void verifyOdrerPlacedAsRetailer() throws IOException {
		ReadDataFromPropertiesFiles readDataFromFiles = new ReadDataFromPropertiesFiles();
		url = readDataFromFiles.readDataFromPropertiesFile("url");		
		retailerUserName = readDataFromFiles.readDataFromPropertiesFile("username");
		retailerPwd = readDataFromFiles.readDataFromPropertiesFile("password");
		String browser=readDataFromFiles.readDataFromPropertiesFile("browser");
		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "FireFox":
			driver=new FirefoxDriver();
			break;
		case "Edge": 
			driver=new EdgeDriver();
		default:
			
  			break;
		}
		
		wDriverUtil= new WebDriverUtil(driver);
		wDriverUtil.maximizeWindow();
		wDriverUtil.waitDriver();  
		LoginPage lPage=new LoginPage(driver);
		lPage.login(browser, browser, browser);
	}
}
