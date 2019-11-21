package enums;

public class Main {
	
	static double g_swe = 9.82;
	static double G = 6.67408*Math.pow(10, -11);
	static double R = 8.3144621;
	static double p_0 = 1000;
	static double c = 299792458;
	

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
	public static double fluidPressure(FluidTable fluid, double deep) {
		double Pressure = 0;
		Pressure = fluid.density*g_swe*deep;
		return Pressure;
	}
}

