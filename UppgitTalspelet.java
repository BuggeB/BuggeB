import java.util.Random;
import java.util.Scanner;

public class UppgitTalspelet {
	
	static Scanner input = new Scanner(System.in); //Importerar scanner till hela klassen
	static Random rand = new Random(); //Global variabel för att randomisera ett tal
	static String playername; //Global variabel för att spelaren ska kunna skriva in eget namn
	static int playerGuess; //Global variabel för hur många gissningar en spelare har gjort
	static int EasyMediumHard; //Global variabel för svårighetsgraderna
	static int RightAnswer; //Global variabel för det korrekta svaret
	static int Hints = 0; //Global variabel för ledtrådar

	public static void main(String[] args) {
		TalSpelet(); //Tilkallar metoden talspelet
	}

	/**
	 * Den här metoden sätter igång själva spelet
	 */
	public static void TalSpelet() {
		System.out.println("Välkommen till Talspelet!");
		regler();
		System.out.println("Vad heter du?");
		String playername = input.nextLine();

		System.out.println("Välj svårighetsgrad: \n 1(Lätt) \n 2(medel) \n 3(Svår)");
		while (true) {
			System.out.println("Skriv in ett nummer mellan 1-3 beroende på svårighetsgrad!");
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
	 * Denna metod letar efter en Integer och om den inte får en Integer så kommer metoden att ställa en fråga igen
	 * @return Integer
	 */
	public static int Exception() {
		String WrongFromUser = "";
		while (true) {
			WrongFromUser = input.nextLine();
			try {
				return Integer.parseInt(WrongFromUser);

			} catch (Exception e) {
				System.out.println("Fel input! Du måste skriva siffror!");
				input.hasNext();
			}
		}
	}
/**
 * Denna metod är till för den lättaste leveln och ger en ledtråd för varje gång man gissat fel tal
 */
	public static void EasyHint() {
		if (EasyMediumHard == 1) {
			if (Hints == 7) {
				System.out.println("Du har förlorat!");
				Restart();
			} else if (playerGuess < RightAnswer) {
				System.out.println("Talet är större!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer) {
				System.out.println("Talet är mindre!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess == RightAnswer) {
				System.out.println("Du gissade rätt!");
				Restart();
			}
		}

	}

	/**
	 * Denna metod är till för medel leveln och ger en ledtråd för varje gång man gissar fel tal
	 */
	public static void MediumHint() {
		if (EasyMediumHard == 2) {
			if (playerGuess < RightAnswer - 5) {
				System.out.println("Du är långt ifrån!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer + 5) {
				System.out.println("Du är långt ifrån!");
				System.out.println("Antal Gissningar " + Hints);
			} else {
				System.out.println("Du är nära!");
				System.out.println("Antal Gissningar " + Hints);
			}
			if (playerGuess == RightAnswer) {
				System.out.println("Du gissade rätt!");
				Restart();
			}
		}
	}

	/**
	 * Denna metoden är till för den svåaste leveln och säger till spelaren att gissa igen eftersom man inte får några ledtrådar
	 */
	public static void HardHint() {
		if (EasyMediumHard == 3) {
			if (playerGuess < RightAnswer) {
				System.out.println("Du gissade fel, försök igen!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer) {
				System.out.println("Du gissade fel, försök igen!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess == RightAnswer) {
				System.out.println("Du gissade rätt!");
				Restart();
			}
		}
	}

	/**
	 * Denna metod frågar om du vill starta om spelet eller avsluta det genom att tryck 1 eller 2
	 */
	public static void Restart() {
		System.out.println(Hints);
		System.out.println("Skriv 1 för att starta om, Skriv 2 om du vill avlsuta spelet");
		int UserChoice = Exception();
		if (UserChoice == 1) {
			TalSpelet();
		} else if (UserChoice == 2) {
			System.exit(0);
		} else {
			System.out.println("Skriv 1 för att starta om, Skriv 2 om du vill avlsuta spelet");
		}
	}

	/**
	 * Denna metod randomiserar det rätta talet mellan 0-25
	 */
	public static void RandomNumber() {
		if (EasyMediumHard == 1 || EasyMediumHard == 2 || EasyMediumHard == 3) {
			RightAnswer = rand.nextInt(26);
		}
	}

	/**
	 * Denna metod förklarar reglerna för talspelet
	 */
	public static void regler() {
		System.out.println(
				"Spelets Regler: \n Du väljer en svåirghets grad Lätt/Medel/Svår \n Gissa på ett tal mellan 1-25 \n Gissar du fel kommer du få ledtrådar som hjälper dig exluderat den svåraste leveln \n Om du får slut på gissningar vinner jag \n Om du gissar på rätt tal vinner du \n Lycka till! ");
	}
}
