package JavaPackage;

public class Call_a_Method {

	static void myFirstMethod() {
		System.out.println("I just got executed! First");
	}
	
	static void mySecondMethod() {
		System.out.println("I just got executed! Second");
	}

	public static void main(String[] args) {
		myFirstMethod();
		mySecondMethod();
		System.out.println(myMethod(3));
	}
	//Method which Return Value

	static int myMethod(int x) {
		return 5 + x;
	}

}
