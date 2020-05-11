import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Slutprojekt {

	static Scanner input = new Scanner(System.in);
	static String userInput;
	static int difficulties;
	static int playerGuess = 0;
	static String[] easyWords = {"Hej"};
	static String[] hardWords = {"Banan"};
	static String word;
	static String unknown;
	static List<String> wrongGuess = new ArrayList<String>();
	
	public static void main(String[] args) {
		Spelet();

	}

	public static void Spelet () {
		System.out.println("V�lkommen till H�nga Gubbe!");
		regler();
		System.out.println("Vad heter du?");
		String userInput = input.nextLine();
		chooseDifficulty();
		while (playerGuess < 10) {
			System.out.println("Gissa p� en bokstav");
			String guess = input.next();
			hang(guess);
		}
		
	}
	
	public static void hang(String guess) {
		String newUnknown = "";
		for (int i = 0; i<word.length(); i++) {
			if(word.charAt(i) == guess.charAt(0)) {
				newUnknown += guess.charAt(0);
			}
			else if (unknown.charAt(i)!="_".charAt(0)) {
				newUnknown += unknown.charAt(i);
			}
			else {
				newUnknown += "_";
			}
		}
		if (unknown.equals(newUnknown)) {
			playerGuess++;
			wrongGuess.add(guess);
			System.out.println(Arrays.toString(wrongGuess.toArray()));
			System.out.println("Fel gissning!");
		}
		else {
			unknown = newUnknown;
			System.out.println("R�tt gissning!");
		}
		if (unknown.equalsIgnoreCase(word)) {
			System.out.println("Grattis du vann!");
		}
	}
	
	public static void chooseDifficulty() {
			System.out.println("V�lj sv�righetsgrad: \n 1 (L�tt) \n 2 (Sv�r)");
			difficulties = input.nextInt();
		if(difficulties == 1) {
			word = easyWords [(int) (Math.random() * easyWords.length)];
		}
		else {
			word = easyWords [(int) (Math.random() * hardWords.length)];
		}
		unknown = new String(new char[word.length()]).replace("\0", "_");
		System.out.println(word+" "+unknown);
	}

	public static void regler() {
		System.out.println(
				"Spelets regler: \n V�lj sv�righetsgrad, klicka 1 f�r l�ttare grad, klicka 2 f�r lite utmaning \n Gissa p� ordet \n Gissar du r�tt p� en bokstav kommer den komma upp i ordet \n Gissar du r�tt p� hela ordet vinner du \n Lycka till!");
	}

	public static int Exception() {
		String WrongFromUser = "";
		while (true) {
			WrongFromUser = input.nextLine();
			try {
				return Integer.parseInt(WrongFromUser);

			} catch (Exception e) {
				System.out.println("Fel input! Du m�ste skriva 1 eller 2!");
				input.hasNext();
			}
		}
	}
}
