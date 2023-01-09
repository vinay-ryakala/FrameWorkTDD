package SDET11_VIN.SDET11_VIN;

class Demo1 {
	String nameString;

	public Demo1() {
		nameString = "supper";
	}

	public void name() {
		System.out.println(" I am parent");
	}
}

public class Demo extends Demo1 {
	String nameString;

	public Demo(String nameString) {
		super();
		this.nameString = nameString;
		System.out.println(nameString);
		this.nameString = super.nameString;

	}

	public Demo() {
		this("abc");

	}

	public void name() {

		System.out.println("I AM child ");
	}

	public void callBoth() {
		this.name();
		super.name();
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		System.out.println(demo.nameString);
		demo.callBoth();
		

	}

}
