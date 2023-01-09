package com.epr.manage.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageManufacturer {
	@FindBy(xpath = "//a[.='Edit Profile']")
	private WebElement editProfile;
	@FindBy(xpath = "//a[.='Add Products']")
	private WebElement addProduct;
	@FindBy(xpath = "//a[.='Manage Category']")
	private WebElement manageCategory;
	@FindBy(xpath = "//a[.='Manage Stock']")
	private WebElement manageStock;
	@FindBy(xpath = "//a[.='Manage Unit']")
	private WebElement manageUnit;
	@FindBy(xpath = "//a[.='Change Password']")
	private WebElement changePassword;
	@FindBy(xpath = "//a[.='Home']")
	private WebElement home;
	@FindBy(xpath = "//a[.='Retailers']")
	private WebElement retailers;
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
	public HomePageManufacturer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddProduct() {
		return addProduct;
	}
	public WebElement getEditProfile() {
		return editProfile;
	}
	public WebElement getManageCategory() {
		return manageCategory;
	}
	public WebElement getManageUnit() {
		return manageUnit;
	}
	public WebElement getManageStock() {
		return manageStock;
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
