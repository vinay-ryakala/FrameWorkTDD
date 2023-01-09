package SDET11_VIN.SDET11_VIN;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoTestNgTest {
	@BeforeSuite
	public void connectDB()
	{
		System.out.println("Connect to Db");
	}
	@BeforeClass
	public void openBrowser() {
		System.out.println("open Browser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("login");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}

	@Test
	public void test2() {
		System.out.println("test2");
	}

	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("open Browser");
	}
	@AfterSuite
	public void closeDBconnection()
	{
		System.out.println("remove db connection");
	}
}
