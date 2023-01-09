package com.ERP.DDT;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFromJsonSample {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader = new FileReader("./Data/sample.json");
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(reader);
		Iterator iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			String nameString = (String) jsonObject.get("name");
			String genderString = (String) jsonObject.get("gender");
			// String subString = (String)jsonObject.get("sub");
			System.out.println(nameString + "   " + genderString);
			JSONArray subJsonArray = (JSONArray) jsonObject.get("sub");
		//	System.out.println(subJsonArray);
			Iterator iterator1 = subJsonArray.iterator();
			int i=1;
			while (iterator1.hasNext()) {
				JSONObject jsonObject1 = (JSONObject) iterator1.next();
				String lan1 = (String) jsonObject1.get("lan"+i);
				System.out.println(lan1);
				i++;
			}
		
		}
		// JSONObject jsonObject= (JSONObject) parser.parse(reader);

	}

}
