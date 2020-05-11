import java.util.Scanner;

public class Slutprojekt {

	static Scanner input = new Scanner(System.in);
	static String playername;
	
	
	public static void main(String[] args) {
		

	}
	public static void Spelet () {
		System.out.println("Välkommen till Hänga Gubbe!");
		regler();
		System.out.println("Vad heter du?");
		String playername = input.nextLine();
	}
}
