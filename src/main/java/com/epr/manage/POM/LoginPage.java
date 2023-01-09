package com.epr.manage.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ERP.mange.genric.WebDriverUtil;

public class LoginPage {
	WebDriver driver;
	@FindBy(name = "txtUsername")
	private WebElement userName;
	@FindBy(name="txtPassword")
	private WebElement pwd;
	@FindBy(id = "login:type")
	private WebElement loginType;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement submitButton;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	WebDriverUtil wDriverUtil= new WebDriverUtil(driver);
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPwd() {
		return pwd;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public void login(String uName, String passWord,String loginAS) {
		userName.sendKeys(uName);
		pwd.sendKeys(passWord);
		wDriverUtil.dropdownHandling(loginAS, loginType);
		submitButton.click();
	}
	
}	
