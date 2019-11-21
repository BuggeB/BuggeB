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
		System.out.println(fluidPressure(FluidTable.WATER, 10));
		System.out.println(pressureUnderWater(10));
		System.out.println(kineticEnergy(2,2));
		System.out.println(potentialEnergy(2,5));
		System.out.println(fallSpeed(2.5));
		System.out.println(delta(1,10));
		System.out.println(volumeToMass(FluidTable.WATER,1));
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
		double FluidPressure = 0;
		FluidPressure = fluid.density*g_swe*deep;
		return FluidPressure;	
	}
	public static double pressureUnderWater(double deep) {
		double pressureWaterPressure = FluidTable.WATER.density*g_swe*deep;
		return pressureWaterPressure;
	}
	public static double kineticEnergy(double mass, double velocity) {
		double kineticEnergy = 0.5*mass*Math.pow(velocity, 2);
		return kineticEnergy;
	}
	public static double potentialEnergy(double mass, double height) {
		double potentialEnergy = mass*g_swe*height;
		return potentialEnergy;
	}
	public static double fallSpeed(double height) {
		double speed = Math.sqrt(2*g_swe*height);
		return speed;
	}
	public static double delta(double first, double last) {
		double difference = last - first;
		return difference;
	}
	public static double volumeToMass(FluidTable fluid, double volume) {
		double volumeToMass = fluid.density*volume;
		return volumeToMass;
	}
}

