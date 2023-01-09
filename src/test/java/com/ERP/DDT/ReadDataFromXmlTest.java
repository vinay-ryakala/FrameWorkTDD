package com.ERP.DDT;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlTest {

	@Test
	public void readDataFromXmlTest(XmlTest xml) {
		System.out.println(xml.getParameter("url"));
	}
}
