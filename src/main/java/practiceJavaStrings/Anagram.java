package practiceJavaStrings;

import java.util.Arrays;

public class Anagram {
/*what I learned in this program :
 * 1) Array can not use toString method array is an object here To string method is not 
 * overrided it gives object address not the string format
 * 2)To convert arrays into strings we can use string value of method
 * 3)To compare to arrays we can use Arrays,equals method
 */
	

	public static void main(String[] args) {
		String word1="abcde",word2="edabc";
		if (word1.length()==word2.length()) {
			char[] a1=word1.toCharArray();
			char[] a2=word2.toCharArray();
			Arrays.sort(a1);
			Arrays.sort(a2);
			Arrays.equals(a1, a2);
			System.out.println(a2);
			System.out.println(a1);
			System.out.println(a1.toString().equals(a2.toString()));
		
			System.out.println(Arrays.equals(a1, a2) +" "+String.valueOf(a2).equals(String.valueOf(a1)));
		} else {
			System.out.println("given words are not angrams");
		}
	}

}
