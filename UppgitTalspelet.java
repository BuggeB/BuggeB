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
}
