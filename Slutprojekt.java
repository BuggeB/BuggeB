import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Slutprojekt {

	static Scanner input = new Scanner(System.in); //Initierar Scannern
	static String userInput; // Gör så att konsolen sparar namnet
	static int difficulties; // Gör så att konsolen sparar svårighetsgraden
	static int playerGuess = 0; // Räknar antalet gissningar spelaren har gissat
	static String[] easyWords = { "Hej", "Banan" }; // En lista över alla lätta ord
	static String[] hardWords = { "Banan" }; // En lista över alla svåra ord
	static String word; // Det valda ordet
	static String unknown; // Den onsynliga varianten av det valda ordet
	static List<String> wrongGuess = new ArrayList<String>(); // En lista med alla felaktiga gissningar
	static boolean restart = true; // Variabel som säger om koden kommer köra igen

	/**
	 * Startar själva spelet
	 */
	public static void main() {
		Spelet();

	}

	/**
	 * Den här metoden introducerar själva spelet, sedan börjar den en loop som kör de andra metoderna.
	 */
	public static void Spelet() {
		System.out.println("Välkommen till Hänga Gubbe!");
		regler();
		System.out.println("Vad heter du?");
		String userInput = input.nextLine();
		while(restart) {
		chooseDifficulty();
		while (playerGuess < 10 && unknown.contains("_")) {
			System.out.println("Gissa på en bokstav");
			String guess = input.next();
			hang(guess);
		}
		}
	}
	/**
	 * Den här metoden börjar med att jämföra det felaktiga gissningarna med den nuvarande gissningen
	   för att säkerställa att bokstaven inte har gissats på tidigare. 
	   Sedan så kallar den på "formatWord" och sedan jämför resultatet med tidigare gissningar för att 
	   se status i spelet.
	 * @param guess den är bokstaven som spelaren har gissat på.
	 */
	public static void hang(String guess) {
		if (wrongGuess.contains(guess.toLowerCase())) {
			System.out.println("Du har redan gissat på denna bokstav!");
			return;
		}
		String newUnknown = formatWord(guess);
		
		if (unknown.equals(newUnknown)) {
			playerGuess++;
			wrongGuess.add(guess.toLowerCase());
			System.out.println(Arrays.toString(wrongGuess.toArray()));
			int remainingGuesses = 10-playerGuess;
			System.out.println("Fel gissning du har " + remainingGuesses + " gissningar kvar!");
		} else {
			unknown = newUnknown;
			System.out.println("Rätt gissning!");
			System.out.println(unknown);
		}
		if (unknown.equalsIgnoreCase(word)) {
			System.out.println("Grattis du vann!");
			playerGuess = 0;
			wrongGuess = new ArrayList<String>();
			System.out.println("Om du vill spela igen klicka 1, om du vill avsluta klicka 2");
			int answer = input.nextInt();
			if (answer == 2) {
				restart = false;
				System.out.println("Tack för att du spelade!");
			}
		}
	}

	public static void chooseDifficulty() {
		System.out.println("Välj svårighetsgrad: \n 1 (Lätt) \n 2 (Svår)");
		difficulties = exception();
		if (difficulties == 1) {
			Random r = new Random();
			int wordIndex = r.nextInt(easyWords.length);
			word = easyWords[wordIndex];
		} else {
			word = hardWords[(int) (Math.random() * hardWords.length)];
		}
		unknown = new String(new char[word.length()]).replace("\0", "_");
		for (char ch : unknown.toCharArray()) {
			System.out.print(ch);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void regler() {
		System.out.println(
				"Spelets regler: \n Välj svårighetsgrad, klicka 1 för lättare grad, klicka 2 för lite utmaning \n Gissa på ordet \n Gissar du rätt på en bokstav kommer den komma upp i ordet \n Gissar du rätt på hela ordet vinner du \n Lycka till!");
	}
	public static String formatWord(String guess) {
		String newUnknown = "";
		for (int i = 0; i < word.length(); i++) {
			char wordChar = Character.toLowerCase(word.charAt(i));
			char guessChar = Character.toLowerCase(guess.charAt(0));
			if (wordChar == guessChar) {
				newUnknown += guessChar;
			} else if (unknown.charAt(i) != "_".charAt(0)) {
				newUnknown += unknown.charAt(i);
			} else {
				newUnknown += "_";
			}
		}
		return newUnknown;
	}

	public static int exception() {
		while (true) {
			try {
				int WrongFromUser = input.nextInt();
				return WrongFromUser;

			} catch (Exception e) {
				System.out.println("Fel input! Du måste skriva 1 eller 2!");
				System.out.println(e);
				input.hasNext();
			}
		}
	}
}
