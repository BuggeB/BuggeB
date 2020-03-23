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
	}

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

	public static void EasyHint() {
		if (EasyMediumHard == 1) {
			if (Hints == 7) {
				System.out.println("Du har f�rlorat!");
				Result();
			} else if (playerGuess < RightAnswer) {
				System.out.println("Talet �r st�rre!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess > RightAnswer) {
				System.out.println("Talet �r mindre!");
				System.out.println("Antal Gissningar " + Hints);
			} else if (playerGuess == RightAnswer) {
				System.out.println("Du gissade r�tt!");
				Result();
			}
		}

	}
	public static void MediumHint () {
		 if (EasyMediumHard == 2) {
			 if (playerGuess < RightAnswer-5) {
				 System.out.println("Du �r l�ngt ifr�n!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else if (playerGuess > RightAnswer+5) {
				 System.out.println("Du �r l�ngt ifr�n!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else {
				 System.out.println("Du �r n�ra!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 if (playerGuess == RightAnswer) {
				 System.out.println("Du gissade r�tt!");
				 Result ();
			 }
		 }
	 }
	public static void HardHint () {
		 if (EasyMediumHard == 3) {
			 if (playerGuess < RightAnswer) {
				 System.out.println("Du gissade fel, f�rs�k igen!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else if (playerGuess > RightAnswer) {
				 System.out.println("Du gissade fel, f�rs�k igen!");
				 System.out.println("Antal Gissningar " + Hints);
			 }
			 else if (playerGuess == RightAnswer) {
				 System.out.println("Du gissade r�tt!");
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
				"Spelets Regler: \n Du v�ljer en sv�irghets grad L�tt/Medel/Sv�r \n Gissa p� ett tal mellan 1-25 \n Gissar du fel kommer du f� ledtr�dar som hj�lper dig exluderat den sv�raste leveln \n Om du f�r slut p� gissningar vinner jag \n Om du gissar p� r�tt tal vinner du \n Lycka till! ");
	}
}
