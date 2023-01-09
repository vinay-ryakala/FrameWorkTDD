package practiceJavaStrings;

import java.util.HashSet;
import java.util.Set;

public class PermutationsOfString {
	static Set<String> hmSet= new HashSet<>();
	public static Set<String> permutation(String str, int i, String perm) {
		
		if (str.length()==0) {
			hmSet.add(perm);
			//System.out.print(perm+"  ");
			
		}
		for (int j = 0; j < str.length(); j++) {
			char first = str.charAt(j);
			String nstr = str.substring(0,j)+str.substring(j+1);
			permutation(nstr, i+1, perm+first);
		}
		return hmSet;
	}
	public static void main(String[] args) {
		System.out.println(permutation("ram",0,""));
		//System.out.println(hmSet);
	}
}
