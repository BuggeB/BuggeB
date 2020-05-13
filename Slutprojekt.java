import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Slutprojekt {

	static Scanner input = new Scanner(System.in);
	static String userInput;
	static int difficulties;
	static int playerGuess = 0;
	static String[] easyWords = { "Hej", "Banan" };
	static String[] hardWords = { "Banan" };
	static String word;
	static String unknown;
	static List<String> wrongGuess = new ArrayList<String>();
	static boolean restart = true;

	public static void main(String[] args) {
		Spelet();

	}

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

	public static void hang(String guess) {
		if ()
		String newUnknown = formatWord(guess);
		
		if (unknown.equals(newUnknown)) {
			playerGuess++;
			wrongGuess.add(guess.toLowerCase());
			System.out.println(Arrays.toString(wrongGuess.toArray()));
			System.out.println("Fel gissning!");
		} else {
			unknown = newUnknown;
			System.out.println("Rätt gissning!");
			System.out.println(unknown);
		}
		if (unknown.equalsIgnoreCase(word)) {
			System.out.println("Grattis du vann!");
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
		String WrongFromUser = "";
		while (true) {
			WrongFromUser = input.nextLine();
			try {
				return Integer.parseInt(WrongFromUser);

			} catch (Exception e) {
				System.out.println("Fel input! Du måste skriva 1 eller 2!");
				input.hasNext();
			}
		}
	}
}
