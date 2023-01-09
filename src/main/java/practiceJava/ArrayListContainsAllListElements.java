package practiceJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListContainsAllListElements {
	public static void main(String[] args) {
		ArrayList<Integer> originArrayList = new ArrayList<Integer>(Arrays.asList(21, 30, 40, 50, 60, 70));
		ArrayList<Integer> smallArrayList = (ArrayList<Integer>) Arrays.asList(30, 40, 50);
		boolean v = originArrayList.containsAll(smallArrayList);
		System.out.println("does originArrayList contains smallArrayList : "+v);
		//array list to array
		Integer[] listToArray = new Integer [originArrayList.size()];
		originArrayList.toArray(listToArray);
		//to print array using to string method
		System.out.println(Arrays.toString(listToArray));
		// to reverse an array list
		Collections.reverse(originArrayList);
		System.out.println("After reverse : "+originArrayList);
		//TO swap to element in array list using collection
		System.out.println("before swap :"+smallArrayList);
		Collections.swap(smallArrayList, 0, 2);
		System.out.println("after swap :"+smallArrayList);
	}
}
