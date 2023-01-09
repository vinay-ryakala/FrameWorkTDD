package practiceJavaStrings;

public class ReverseOfStringUsingRecursion {
	
	public static String reverseOfString(String givenString) {
		if (givenString.isEmpty()) {
			return givenString;
			// System.out.print(givenString);
		} else {
			// System.out.print(givenString.charAt(givenString.length()-1));
			// reverseOfString(givenString.substring(0, givenString.length()-1));
			return givenString.charAt(givenString.length() - 1)
					+ reverseOfString(givenString.substring(0, givenString.length() - 1));

		}

	}
	private static String reverseString(String givenString) {
		if (givenString.isEmpty()) {
			return givenString;
		}else {
			return reverseOfString(givenString.substring(1))+givenString.charAt(0);
		}
		
	}
	public static void rotateSrtring(String name,int i) {
		 String nameAfterRotate = name.substring(i)+name.substring(0, i);
		 System.out.println(nameAfterRotate);
	}
	public static void main(String[] args) {
		System.out.println(reverseOfString("123a bc defgh i"));
		System.out.println(reverseString("123a bc defgh i"));
		String givenString="I am vinay ";
		String[] wordArrayStrings=givenString.split(" ");
		String reverseWordWise="";
		String reverseUsingStringBuilderString="";
		for (String stringWord : wordArrayStrings) {
			reverseWordWise+=reverseString(stringWord)+" ";
			StringBuilder sbsBuilder= new StringBuilder(stringWord);
			
			reverseUsingStringBuilderString+=sbsBuilder.reverse().toString()+" ";
			
		}
		System.out.println(reverseWordWise);
		System.out.println(reverseUsingStringBuilderString);
		rotateSrtring(givenString, 2);
	}
  
}
