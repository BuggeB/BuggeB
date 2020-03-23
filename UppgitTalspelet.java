import java.util.Random;
import java.util.Scanner;

public class UppgitTalspelet {
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	static String playername;
	static int playerGuess;
	static int EasyMediumHard;
	static int RightAnswer;
	static int Hints = 0;
	static boolean hard = false;

	public static void main(String[] args) {
		TalSpelet();
	}

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
	}

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

	public static void EasyHint() {
		if (EasyMediumHard == 1) {
			if (Hints == 7) {
				System.out.println("Du har förlorat!");
				Result();
			} else if (playerGuess < RightAnswer) {
				System.out.println("Talet är större!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer) {
				System.out.println("Talet är mindre!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess == RightAnswer) {
				System.out.println("Du gissade rätt!");
				Result();
			}
		}

	}
	public static void MediumHint () {
		 if (EasyMediumHard == 2) {
			 if (playerGuess < RightAnswer-5) {
				 System.out.println("Du är långt ifrån!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else if (playerGuess > RightAnswer+5) {
				 System.out.println("Du är långt ifrån!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else {
				 System.out.println("Du är nära!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 if (playerGuess == RightAnswer) {
				 System.out.println("Du gissade rätt!");
				 Result ();
			 }
		 }
	 }
	public static void HardHint () {
		 if (EasyMediumHard == 3) {
			 if (playerGuess < RightAnswer) {
				 System.out.println("Du gissade fel, försök igen!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else if (playerGuess > RightAnswer) {
				 System.out.println("Du gissade fel, försök igen!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else if (playerGuess == RightAnswer) {
				 System.out.println("Du gissade rätt!");
				 Result ();
			 }
		 }
	 }

	public static void RandomNumber() {
		if (EasyMediumHard == 1 || EasyMediumHard == 2 || EasyMediumHard == 3) {
			RightAnswer = rand.nextInt(26);
		}
	}

	public static void regler() {
		System.out.println(
				"Spelets Regler: \n Du väljer en svåirghets grad Lätt/Medel/Svår \n Gissa på ett tal mellan 1-25 \n Gissar du fel kommer du få ledtrådar som hjälper dig exluderat den svåraste leveln \n Om du får slut på gissningar vinner jag \n Om du gissar på rätt tal vinner du \n Lycka till! ");
	}
}
