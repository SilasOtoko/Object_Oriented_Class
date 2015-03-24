package ch7;

public class Main {
	public static void main(String[] args){
		Car smart = new Car("smart", 1000, 20);
		Car tesla = new Car("tesla");
		System.out.println(smart.toString());
		System.out.println(tesla.toString());
	}
	
	
}
