package practiceJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShuffleArrayList {
	public static void main(String[] args) {

//		 * Initializing array list at the time of declaration Using Arrays.asList
		
		ArrayList originArrayList = new ArrayList(Arrays.asList(21,30,40,50,60,70)) ;
		System.out.println(originArrayList);
		Collections.shuffle(originArrayList);
		System.out.println(originArrayList);
	
}}
