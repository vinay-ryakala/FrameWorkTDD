package com.epr.manage.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ERP.mange.genric.BaseClass;
import com.ERP.mange.genric.WebDriverUtil;

public class AddManufacturerPage {
	@FindBy(id = "manufacturer:name")
	private WebElement manufacturerName;
	@FindBy(id = "manufacturer:email")
	private WebElement manufacturerEmail;
	@FindBy(id = "manufacturer:phone")
	private WebElement manufacturerPhone;
	@FindBy(id = "manufacturer:username")
	private WebElement manufacturerUN;
	@FindBy(id = "manufacturer:password")
	private WebElement manufacturerPwd;
	@FindBy(xpath = "//input[@value='Add Manufacturer']")
	private WebElement addButtonElement;
	public AddManufacturerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	WebDriverUtil wd=new WebDriverUtil(BaseClass.sdriver);
	public WebElement getManufacturerName() {
		return manufacturerName;
	}
	public WebElement getManufacturerEmail() {
		return manufacturerEmail;
	}
	public WebElement getManufacturerPhone() {
		return manufacturerPhone;
	}
	public WebElement getManufacturerUN() {
		return manufacturerUN;
	}
	public WebElement getManufacturerPwd() {
		return manufacturerPwd;
	}
	public void createNewManufacturer(String name,String email,String phone,String Uname,String Pwd) {
		manufacturerName.sendKeys(name);
		manufacturerEmail.sendKeys(email);
		manufacturerPhone.sendKeys(phone);
		manufacturerUN.sendKeys(Uname);
		manufacturerPwd.sendKeys(Pwd);
		addButtonElement.click(); 
		wd.acceptAlert();
		
	}
	
}
