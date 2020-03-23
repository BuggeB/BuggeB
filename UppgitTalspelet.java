import java.util.Random;
import java.util.Scanner;

public class UppgitTalspelet {
	
	static Scanner input = new Scanner(System.in); //Importerar scanner till hela klassen
	static Random rand = new Random(); //Global variabel f�r att randomisera ett tal
	static String playername; //Global variabel f�r att spelaren ska kunna skriva in eget namn
	static int playerGuess; //Global variabel f�r hur m�nga gissningar en spelare har gjort
	static int EasyMediumHard; //Global variabel f�r sv�righetsgraderna
	static int RightAnswer; //Global variabel f�r det korrekta svaret
	static int Hints = 0; //Global variabel f�r ledtr�dar

	public static void main(String[] args) {
		TalSpelet(); //Tilkallar metoden talspelet
	}

	/**
	 * Den h�r metoden s�tter ig�ng sj�lva spelet
	 */
	public static void TalSpelet() {
		System.out.println("V�lkommen till Talspelet!");
		regler();
		System.out.println("Vad heter du?");
		String playername = input.nextLine();

		System.out.println("V�lj sv�righetsgrad: \n 1(L�tt) \n 2(medel) \n 3(Sv�r)");
		while (true) {
			System.out.println("Skriv in ett nummer mellan 1-3 beroende p� sv�righetsgrad!");
			EasyMediumHard = Exception();
			if (EasyMediumHard == 1 || EasyMediumHard == 2 || EasyMediumHard == 3) {
				break;
			}
		}
		RandomNumber();

		while (playerGuess != RightAnswer) {
			System.out.println("Skriv en siffra: ");
			playerGuess = Exception();
			Hints++;
			EasyHint();
			MediumHint();
			HardHint();
		}
	}

	/**
	 * Denna metod letar efter en Integer och om den inte f�r en Integer s� kommer metoden att st�lla en fr�ga igen
	 * @return Integer
	 */
	public static int Exception() {
		String WrongFromUser = "";
		while (true) {
			WrongFromUser = input.nextLine();
			try {
				return Integer.parseInt(WrongFromUser);

			} catch (Exception e) {
				System.out.println("Fel input! Du m�ste skriva siffror!");
				input.hasNext();
			}
		}
	}
/**
 * Denna metod �r till f�r den l�ttaste leveln och ger en ledtr�d f�r varje g�ng man gissat fel tal
 */
	public static void EasyHint() {
		if (EasyMediumHard == 1) {
			if (Hints == 7) {
				System.out.println("Du har f�rlorat!");
				Restart();
			} else if (playerGuess < RightAnswer) {
				System.out.println("Talet �r st�rre!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer) {
				System.out.println("Talet �r mindre!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess == RightAnswer) {
				System.out.println("Du gissade r�tt!");
				Restart();
			}
		}

	}

	/**
	 * Denna metod �r till f�r medel leveln och ger en ledtr�d f�r varje g�ng man gissar fel tal
	 */
	public static void MediumHint() {
		if (EasyMediumHard == 2) {
			if (playerGuess < RightAnswer - 5) {
				System.out.println("Du �r l�ngt ifr�n!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer + 5) {
				System.out.println("Du �r l�ngt ifr�n!");
				System.out.println("Antal Gissningar " + Hints);
			} else {
				System.out.println("Du �r n�ra!");
				System.out.println("Antal Gissningar " + Hints);
			}
			if (playerGuess == RightAnswer) {
				System.out.println("Du gissade r�tt!");
				Restart();
			}
		}
	}

	/**
	 * Denna metoden �r till f�r den sv�aste leveln och s�ger till spelaren att gissa igen eftersom man inte f�r n�gra ledtr�dar
	 */
	public static void HardHint() {
		if (EasyMediumHard == 3) {
			if (playerGuess < RightAnswer) {
				System.out.println("Du gissade fel, f�rs�k igen!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer) {
				System.out.println("Du gissade fel, f�rs�k igen!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess == RightAnswer) {
				System.out.println("Du gissade r�tt!");
				Restart();
			}
		}
	}

	/**
	 * Denna metod fr�gar om du vill starta om spelet eller avsluta det genom att tryck 1 eller 2
	 */
	public static void Restart() {
		System.out.println(Hints);
		System.out.println("Skriv 1 f�r att starta om, Skriv 2 om du vill avlsuta spelet");
		int UserChoice = Exception();
		if (UserChoice == 1) {
			TalSpelet();
		} else if (UserChoice == 2) {
			System.exit(0);
		} else {
			System.out.println("Skriv 1 f�r att starta om, Skriv 2 om du vill avlsuta spelet");
		}
	}

	/**
	 * Denna metod randomiserar det r�tta talet mellan 0-25
	 */
	public static void RandomNumber() {
		if (EasyMediumHard == 1 || EasyMediumHard == 2 || EasyMediumHard == 3) {
			RightAnswer = rand.nextInt(26);
		}
	}

	/**
	 * Denna metod f�rklarar reglerna f�r talspelet
	 */
	public static void regler() {
		System.out.println(
				"Spelets Regler: \n Du v�ljer en sv�irghets grad L�tt/Medel/Sv�r \n Gissa p� ett tal mellan 1-25 \n Gissar du fel kommer du f� ledtr�dar som hj�lper dig exluderat den sv�raste leveln \n Om du f�r slut p� gissningar vinner jag \n Om du gissar p� r�tt tal vinner du \n Lycka till! ");
	}
}
