package com.epr.manage.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ERP.mange.genric.GenrateTestData;
import com.ERP.mange.genric.WebDriverUtil;

public class AddProductsPage {
	WebDriver driver;
	GenrateTestData testData = new GenrateTestData();

	@FindBy(id = "product:name")
	private WebElement productNameWebElement;
	@FindBy(id = "product:price")
	private WebElement productPrice;
	@FindBy(name = "cmbProductUnit")
	private WebElement productUnitDpDown;
	@FindBy(id = "product:category")
	private WebElement productCategory;
	@FindBy(xpath = "//input[@value='1']")
	private WebElement activateProduct;
	@FindBy(xpath = "//input[@value='2']")
	private WebElement deactivateProduct;
	@FindBy(id = "product:description")
	private WebElement discription;
	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement addProductButton;

	public AddProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	WebDriverUtil wDriverUtil = new WebDriverUtil(driver);
	
	public WebElement getProductName() {
		return productNameWebElement;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getProductUnitDpDown() {
		return productUnitDpDown;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getActivateProduct() {
		return activateProduct;
	}

	public WebElement getDeactivateProduct() {
		return deactivateProduct;
	}

	public WebElement getDiscription() {
		return discription;
	}

	public WebElement getAddProductButton() {
		return addProductButton;
	}
	
	public void createProduct(String productName, String pPrice, String productUnit, String productCat, String value) throws InterruptedException {
		productNameWebElement.sendKeys(productName);
		productPrice.sendKeys(pPrice);
		productUnitDpDown.click();
		wDriverUtil.dropdownHandling(productUnitDpDown, productUnit);
		productCategory.click();
		wDriverUtil.dropdownHandling(productCategory, productCat);
		if (value.equalsIgnoreCase("enable")) {
			activateProduct.click();
		} else {
			deactivateProduct.click();
		}
		discription.sendKeys(testData.description(10));
		addProductButton.click();
	//	wDriverUtil.acceptAlert();
	}

	public void editProductName(String nProductName) {
		productNameWebElement.clear();
		productNameWebElement.sendKeys(nProductName);
	}

	public void editProductPrice(String nProductPrice) {
		productPrice.clear();
		productPrice.sendKeys(nProductPrice);
	}

	public void editProductUnit(String productUnit) {
		productUnitDpDown.click();
		wDriverUtil.dropdownHandling(productUnitDpDown, productUnit);
	}

	public void editProductCat(String productCat) {
		productCategory.click();
		wDriverUtil.dropdownHandling(productCategory, productCat);
	}

	public void editStockManagement(String value) {
		if (value.equalsIgnoreCase("enable")) {
			activateProduct.click();
		} else {
			deactivateProduct.click();
		}
	}

	public void editProductDiscription(String des) {
		discription.clear();
		discription.sendKeys(des);
	}

	public void editAllProductDetails(String productName, String pPrice, String productUnit, String productCat,
			String value, String des) {
		editProductName(productName);
		editProductPrice(pPrice);
		editProductUnit(productUnit);
		editProductCat(productCat);
		editStockManagement(value);
		editProductDiscription(des);

	}
}
