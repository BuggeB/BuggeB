package enums;

public class Main {

	public static void main(String[] args) {
		System.out.println(farenheitToCelcius(50.0));
		System.out.println(kelvinToCelcius(0));
	} 
	public static double farenheitToCelcius (double farenheit) {
		double celcius = ((farenheit - 32)*5)/9;
		return celcius;
	}
	public static double kelvinToCelcius (double kelvin) {
		double celcius = (kelvin-273.15);
		return celcius;
	}
	public static double fluidpressure
}

