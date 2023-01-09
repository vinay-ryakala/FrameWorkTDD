package com.ERP.mange.genric;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFiles {
	public String readDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(IAutoConstants.CREDNTIALSPATH);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String value = properties.getProperty(key);
		return value;
	}
	
}
