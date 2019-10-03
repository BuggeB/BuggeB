import java.util.Scanner;

public class Spavanac {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		int H = scan.nextInt();
		int M = scan.nextInt();
		
		M-= 45;
		
		if (M < 0) {
			H-= 1;
			M+= 60;
		}
		if ( H < 0) {
			H = 23;
		}
		
		System.out.println(H + " " + M );
		scan.close();
	}

}
