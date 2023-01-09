package com.ERP.mange.genric;

import java.util.Locale;
import java.util.Random;
import com.github.javafaker.Faker;

public class GenrateTestData {
	// Create an object of Faker class with INDIAN locale i.e IND

	Faker faker = new Faker(new Locale("en-IND")); 

	public int genarateRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}

	// To generate valid random first name
	public String firstName() {
		return faker.name().firstName();
	
	}
	
	// To generate valid ADDRESS
	public String address() {
		return faker.address().fullAddress();
	}

	// To generate valid random cell number
	public String phoneNumber() {
		return faker.phoneNumber( ).cellPhone();
	}

	// To generate valid random food name
	public String productName() {
		return faker.food().dish();
	}

	// To generate valid random Product Price
	public String productPrice() {
		return faker.commerce().price(10, 1000);
	}

	// To generate valid random password
	public String passWord() {
		return faker.regexify("^[A-Za-z0-9]{8,}$");
	}
	//To generate description
	public String description(int numOfWords) {
		return faker.lorem().sentence(numOfWords);
	} 
	public String email() {
		return faker.internet().safeEmailAddress();
	}
}

