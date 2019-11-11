
public class Metoder {

	public static void main(String[] args) {
		System.out.println(farenheitToCelcius(50.0));
	}
	public static double farenheitToCelcius (double farenheit) {
		double celcius = ((farenheit - 32)*5)/9;
		return celcius;
	}
}
