package com.epr.manage.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[.='Add Products']")
	private WebElement addProduct;
	@FindBy(xpath = "//a[.='Add Retailers']")
	private WebElement addRetailer;
	@FindBy(xpath = "//a[.='Add Manufacturer']")
	private WebElement addManufacturer;
	@FindBy(xpath = "//a[.='Add Distributor']")
	private WebElement addDistributor;
	@FindBy(xpath = "//a[.='Manage Unit']")
	private WebElement manageUnit;
	@FindBy(xpath = "//a[.='Manage Area']")
	private WebElement manageArea;
	@FindBy(xpath = "//a[.='Change Password']")
	private WebElement changePassword;
	@FindBy(xpath = "//a[.='Home']")
	private WebElement home;
	@FindBy(xpath = "//a[.='Retailers']")
	private WebElement retailers;
	@FindBy(xpath = "//a[.='Manufacturers']")
	private WebElement manufacturer;
	@FindBy(xpath = "//a[.='Distributors']")
	private WebElement distributors;
	@FindBy(xpath = "//a[.='Products']")  
	private WebElement product;
	@FindBy(xpath = "//a[.='Orders']")
	private WebElement orders;
	@FindBy(xpath = "//a[.='Invoice']")
	private WebElement invoice;
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logOut;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddProduct() {
		return addProduct;
	}
	public WebElement getAddRetailer() {
		return addRetailer;
	}
	public WebElement getAddManufacturer() {
		return addManufacturer;
	}
	public WebElement getAddDistributor() {
		return addDistributor;
	}
	public WebElement getManageUnit() {
		return manageUnit;
	}
	public WebElement getManageArea() {
		return manageArea;
	}
	public WebElement getChangePassword() {
		return changePassword;
	}
	public WebElement getHome() {
		return home;
	}
	public WebElement getRetailers() {
		return retailers;
	}
	public WebElement getManufacturer() {
		return manufacturer;
	}
	public WebElement getDistributors() {
		return distributors;
	}
	public WebElement getProduct() {
		return product;
	}
	public WebElement getOrders() {
		return orders;
	}
	public WebElement getInvoice() {
		return invoice;
	}
	public WebElement getLogOut() {
		return logOut;
	}
	
	
}
