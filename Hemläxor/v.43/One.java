
public class One {
	//Skapar en main string
		public static void main(String[] args) {
			//Under h�r skriver jag Sysout f�r att kunna f� fram ett svar.
			System.out.println(volume(10)+"Liter");}
		
	public static double volume(double radius){
		//Precis under h�r s� f�rklarar jag f�r programmet hur man r�knar ut volymen p� ett klot.
		double volume = (4*Math.PI *Math.pow(radius, 3)/3);
		return volume;
	}
	
	
}