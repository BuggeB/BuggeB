import java.util.Scanner;

public class V37 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Whats your name?");
		String name = scan.next();
		
		System.out.println("Whats your age?");
	 	int age = scan.nextInt();
	 	
	 	System.out.println("Vilken addres har du?");
	 	String addres = scan.next();
	 	
	 	System.out.println("Vad �r ditt postnummer?");
	 	int postnummer = scan.nextInt();
	 	
	 	System.out.println("Vilken stad bor du i?");
	 	String stad = scan.next();
	 	
	 	System.out.println("Vad �r ditt telefonnummer?");
	 	int telefonnummer = scan.nextInt();
	} 
}
