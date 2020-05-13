
// Alla paket som importeras
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Slutprojekt {

	static Scanner input = new Scanner(System.in); // Initierar Scannern
	static String userInput; // G�r s� att konsolen sparar namnet
	static int difficulties; // G�r s� att konsolen sparar sv�righetsgraden
	static int playerGuess = 0; // R�knar antalet gissningar spelaren har gissat
	static String[] easyWords = { "Sko", "Banan", "Mask", "t�g", "�pple", "val", "bok", "rik", "bil", "hatt" }; // En lista �ver alla l�tta ord
	static String[] hardWords = { "hypernervokustiskadiafragmakontravibrationer", "acklamation", "dagrehabilitering", "personalkostnadstill�gg", "reglemente", "sj�lvf�rvaltningsorgan", "k�rnverksamheter", "intrudoktionsers�ttning", "slutprojekt" }; // En lista �ver alla sv�ra ord
	static String word; // Det valda ordet
	static String unknown; // Den onsynliga varianten av det valda ordet
	static List<String> wrongGuess = new ArrayList<String>(); // En lista med alla felaktiga gissningar
	static boolean restart = true; // Variabel som s�ger om koden kommer k�ra igen

	/**
	 * Startar sj�lva h�nga gubbe spelet
	 */
	public static void main() {
		Spelet();

	}

	/**
	 * Den h�r metoden introducerar sj�lva spelet, sedan b�rjar den en loop som k�r
	 * de andra metoderna.
	 */
	public static void Spelet() {
		System.out.println("V�lkommen till H�nga Gubbe!");
		regler();
		System.out.println("Vad heter du?");
		String userInput = input.nextLine();
		while (restart) {
			chooseDifficulty();
			while (playerGuess < 10 && unknown.contains("_")) {
				System.out.println("Gissa p� en bokstav");
				String guess = input.next();
				hang(guess);
			}
		}
	}

	/**
	 * Den h�r metoden b�rjar med att j�mf�ra det felaktiga gissningarna med den
	   nuvarande gissningen f�r att s�kerst�lla att bokstaven inte har gissats p�
	   tidigare. Sedan s� kallar den p� "formatWord" och sedan j�mf�r resultatet med
	   tidigare gissningar f�r att se status i spelet.
	 * @param guess den �r bokstaven som spelaren har gissat p�.
	 */
	public static void hang(String guess) {
		if (wrongGuess.contains(guess.toLowerCase())) {
			System.out.println("Du har redan gissat p� denna bokstav!");
			return;
		}
		String newUnknown = formatWord(guess);

		if (unknown.equals(newUnknown)) {
			playerGuess++;
			wrongGuess.add(guess.toLowerCase());
			System.out.println(Arrays.toString(wrongGuess.toArray()));
			int remainingGuesses = 10 - playerGuess;
			System.out.println("Fel gissning du har " + remainingGuesses + " gissningar kvar!");
		} else {
			unknown = newUnknown;
			System.out.println("R�tt gissning!");
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
				System.out.println("Tack f�r att du spelade!");
			}
		}
	}

	/**
	 * Detta �r en metod som v�ljer ett ord fr�n listorna beroende p� vilken
	 * sv�righetsgrad man har valt ut.
	 */
	public static void chooseDifficulty() {
		System.out.println("V�lj sv�righetsgrad: \n 1 (L�tt) \n 2 (Sv�r)");
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

	/**
	 * Denna metoden skriver ut reglerna till spelet.
	 */
	public static void regler() {
		System.out.println(
				"Spelets regler: \n V�lj sv�righetsgrad, klicka 1 f�r l�ttare grad, klicka 2 f�r lite utmaning \n Gissa p� ordet \n Gissar du r�tt p� en bokstav kommer den komma upp i ordet \n Gissar du r�tt p� hela ordet vinner du \n Lycka till!");
	}

	/**
	 * Den h�r metoden formaterar en String beroende p� k�nda bokst�ver. Det spelar
	   ingen roll om bokstaven �r liten eller stor. 
	 * @param guess den �r bokstaven som spelaren har gissat p�.
	 * @return en String som �r formaterad
	 */
	public static String formatWord(String guess) {
		String newUnknown = "";
		for (int i = 0; i < word.length(); i++) {
			char wordChar = Character.toLowerCase(word.charAt(i)); //CharAt �r en funktion som kollar vad ett visst tecken �r vid en viss index (placering).
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

	/**
	 * Denna metod g�r s� att om man skriver in en bokstav d�r man ska skriva in en
	   int s� skickar den tillbaka ett meddelande som s�ger att man m�ste skriva en
	   int. 
	 * @return Den skrivna integern
	 */
	public static int exception() {
		while (true) {
			try {
				int WrongFromUser = input.nextInt();
				return WrongFromUser;

			} catch (Exception e) {
				System.out.println("Fel input! Du m�ste skriva 1 eller 2!");
				System.out.println(e);
				input.hasNext();
			}
		}
	}
}
