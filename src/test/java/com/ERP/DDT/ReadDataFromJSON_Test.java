package com.ERP.DDT;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadDataFromJSON_Test {
	@Test
	public void readDataFromJson() throws IOException, ParseException {
		// convert
		FileReader fileReader = new FileReader("./Data/simple.json");
		JSONParser parser = new JSONParser();
		Object object = parser.parse(fileReader);
		HashMap map = (HashMap) object;
		String urlString = (String) map.get("url");
		System.out.println(urlString);

	}
}
