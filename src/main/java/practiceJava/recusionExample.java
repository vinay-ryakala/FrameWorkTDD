package practiceJava;



public class recusionExample {
	 int i=0;
	
	public  void name() {
	
		i++;
		System.out.	println( i);
		if (i < 3) {
			name();
			name();

		}

	}

	public static void main(String[] args) {
		recusionExample recusionExampl = new recusionExample();
		recusionExampl.name();
	}
}
