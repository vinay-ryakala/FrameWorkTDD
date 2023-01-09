package com.ERP.DDT;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
@Test
public void readDataFromCmdLine() {
	String urlString = System.getProperty("url");
	String uNameString= System.getProperty("name");
	System.out.println(urlString);
	System.out.println(uNameString);
	new ChromeDriver().get(urlString);
}
}
