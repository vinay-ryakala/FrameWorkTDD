package IntegrationTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ERP.mange.genric.ReadDataFromPropertiesFiles;

public class CreateProductAllTestCases1stVersion {
	String createProduct="Black Forest";
	String editedProduct="Pine Apple";
	ReadDataFromPropertiesFiles readDataFromFiles= new ReadDataFromPropertiesFiles();
	
	@Test(priority = 1)
	public void CreateProductToProductList() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		WebElement dropDownElement = driver.findElement(By.id("login:type"));
		dropDownElement.click();
		Select select = new Select(dropDownElement);
		select.selectByValue("admin");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[.='Add Products']")).click();
		driver.findElement(By.id("product:name")).sendKeys(createProduct);
		driver.findElement(By.id("product:price")).sendKeys("600");
		WebElement dropDownUnit = driver.findElement(By.name("cmbProductUnit"));
		dropDownUnit.click();
		Select selectUnit = new Select(dropDownUnit);
		selectUnit.selectByVisibleText(" KG ");
		WebElement dropDownCat = driver.findElement(By.name("cmbProductCategory"));
		dropDownCat.click();
		Select selectCat = new Select(dropDownCat);
		selectCat.selectByVisibleText(" Cakes ");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Add Product']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'"+createProduct+"')]")).getText();
		System.out.println(productName);
		/*List<WebElement> productNameList=driver.findElements(By.xpath("//table[@class='table_displayData']//tr/td[3]"));
		for (WebElement webElement : productNameList) {
			String productName2 = webElement.getText();
			if (productName2.contains("createProduct")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}*/
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.close();
		
	}
	
	@Test(priority = 2)
	public void checkProductInProductListOfManufacturer() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		driver.findElement(By.name("txtUsername")).sendKeys("zxcvb");
		driver.findElement(By.name("txtPassword")).sendKeys("123456789");
		WebElement dropDownElement = driver.findElement(By.id("login:type"));
		dropDownElement.click();
		Select select = new Select(dropDownElement);
		select.selectByValue("manufacturer");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'"+createProduct+"')]")).getText();
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.close();
		Assert.assertTrue(productName.equals(createProduct), productName + "is not found");

	}

	@Test(priority = 3)
	public void editProductInProductList() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		WebElement dropDownElement = driver.findElement(By.id("login:type"));
		dropDownElement.click();
		Select select = new Select(dropDownElement);
		select.selectByValue("admin");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'"+createProduct+"')]//following-sibling::td/a")).click();
		Thread.sleep(3000);
		WebElement productElement = driver.findElement(By.id("product:name"));
		productElement.clear();
		productElement.sendKeys(editedProduct);
		Thread.sleep(3000);
		WebElement priceElement = driver.findElement(By.id("product:price"));
		priceElement.clear();
		priceElement.sendKeys("500");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Update Product']")).click();
		driver.switchTo().alert().accept();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'"+editedProduct+"')]")).getText();
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		Assert.assertTrue(productName.equals(editedProduct), productName + "is not found");
		driver.close();
		
	}
	@Test(priority = 4)
	public void checkEditedProductInProductListOfManufacturer() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		driver.findElement(By.name("txtUsername")).sendKeys("zxcvb");
		driver.findElement(By.name("txtPassword")).sendKeys("123456789");
		WebElement dropDownElement = driver.findElement(By.id("login:type"));
		dropDownElement.click();
		Select select = new Select(dropDownElement);
		select.selectByValue("manufacturer");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		String productName = driver.findElement(By.xpath("//td[contains(text(),'"+editedProduct+"')]")).getText();
		Assert.assertTrue(productName.equals(editedProduct), productName + "is not found");
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.close();
	}

	@Test(priority = 5)
	public void deleteProductInProductList() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		WebElement dropDownElement = driver.findElement(By.id("login:type"));
		dropDownElement.click();
		Select select = new Select(dropDownElement);
		select.selectByValue("admin");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//td[contains(text(),' "+editedProduct +"')]//preceding-sibling::td/input")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		driver.switchTo().alert().accept();
		try {
			String productName = driver.findElement(By.xpath("//td[contains(text(),'"+editedProduct+"')]")).getText();
			Assert.assertTrue(productName.equals(editedProduct), productName+"is not found");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}

		driver.close();
	}
	@Test(priority = 6)
	public void checkDeletedProductInProductListOfManufacturer() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		driver.findElement(By.name("txtUsername")).sendKeys("zxcvb");
		driver.findElement(By.name("txtPassword")).sendKeys("123456789");
		WebElement dropDownElement = driver.findElement(By.id("login:type"));
		dropDownElement.click();
		Select select = new Select(dropDownElement);
		select.selectByValue("manufacturer");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[.='Products']")).click();
		try {
			String productName = driver.findElement(By.xpath("//td[contains(text(),'"+editedProduct+"')]")).getText();
			Assert.assertTrue(productName.equals(editedProduct), productName+"is not found");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.close();
	}
}