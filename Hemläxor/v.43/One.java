
public class One {
	//Skapar en main string
		public static void main(String[] args) {
			//Under här skriver jag Sysout för att kunna få fram ett svar.
			System.out.println(volume(10)+"Liter");}
		
	public static double volume(double radius){
		//Precis under här så förklarar jag för programmet hur man räknar ut volymen på ett klot.
		double volume = (4*Math.PI *Math.pow(radius, 3)/3);
		return volume;
	}
	
	
}