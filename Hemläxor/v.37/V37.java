import java.util.Scanner;

public class V37 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Whats your name?");
		String name = scan.next();
		
		System.out.println("Whats your age?");
	 	int age = scan.nextInt();
	 	
	 	System.out.println("Thank you " + name + ", you are " + age + " years old");
	} 
}
