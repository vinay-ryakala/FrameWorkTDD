package practiceJavaStrings;

public class SwapOfTwoStringsWithOutThirdVar {
	public static void main(String[] args) {
		String word1="Vinay",word2="Ryakala";
		word1=word1+word2;
		word2=word1.substring(0,word1.length()-word2.length());
		word1=word1.substring(word2.length());
		System.out.println(word1+" "+word2);
	}
}