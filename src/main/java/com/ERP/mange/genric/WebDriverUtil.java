package com.ERP.mange.genric;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	WebDriver driver;
	Select select;
	Actions actions;
	public WebDriverUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void waitDriver() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void dropdownHandling(WebElement element, int index) {
		select= new Select(element);
		select.selectByIndex(index);
	}
	public void dropdownHandling(WebElement element, String visibleText) {
		select= new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void dropdownHandling( String value,WebElement element) {
		select= new Select(element);
		select.selectByValue(value);
	}
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();;
	}
	public void rightClick(WebElement webElement) {
		actions=new Actions(driver);
		actions.contextClick(webElement);
		actions.perform();
	}
	public void dragFromDropTo(WebElement source, WebElement target) {
		actions=new Actions(driver);
		actions.dragAndDrop(source, target);
		actions.perform();
	}
	  
	public void switchToWindow(String title) {
		String currentWindow = driver.getWindowHandle();
		for (String childId : driver.getWindowHandles()) {
			if (!currentWindow.equals(childId)) {
				driver.switchTo().window(childId);
				if (title.contains(driver.getTitle())) {
					break;
				}
				else {
					throw new NoSuchWindowException(title+ " window is not found");
				}
			}
		}
		
	}
	public void jsExecutor(String jsScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript(jsScript);
	}
}
