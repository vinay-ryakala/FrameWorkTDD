package practiceJava;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.AddHasCasting;

public class ArrayListClone {

	public void initalizingUsingAnotherCollection(List arr) {
		// Initializing Array List at the time of declaration using another list
		ArrayList newArrayList = new ArrayList(arr);
		System.out.println("newArrayList : " + newArrayList);
	}

	public void copyOfArrayListUsingClone(ArrayList arr) {
		ArrayList clonedArrayList = new ArrayList();
		clonedArrayList = (ArrayList) arr.clone();
		System.out.println(clonedArrayList);
	}
	
	public void copyOfArrayListUsingAddAll(ArrayList arr) {
		ArrayList coppiedArrayList = new ArrayList();
		coppiedArrayList.addAll(arr);
		System.out.println(coppiedArrayList);
	}

	public static void main(String[] args) {

//		 * Initializing array list at the time of declaration
		ArrayList originArrayList = new ArrayList() {
			{
				add(10);
				add(20);
				add(90);
				add(45);
			}
		};
		System.out.println(originArrayList);
		ArrayListClone arrayListClone= new ArrayListClone();
		arrayListClone.initalizingUsingAnotherCollection(originArrayList);
		arrayListClone.copyOfArrayListUsingAddAll(originArrayList);
		arrayListClone.copyOfArrayListUsingClone(originArrayList);

	}
}
