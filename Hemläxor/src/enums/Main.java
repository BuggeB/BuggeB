package enums;

public class Main {
	
	static double g_swe = 9.82;
	static double G = 6.67408*Math.pow(10, -11);
	static double R = 8.3144621;
	static double p_0 = 1000;
	static double c = 299792458;
	

	public static void main(String[] args) {
		
		
		System.out.println(volumeToMassSolid(SolidTable.IRON, 0.06));
		System.out.println(svtDistance (2.7, 3000));
		System.out.println(heatFluid(FluidTable.WATER,4, FluidTable.WATER.boilPoint));
		System.out.println();
		
		
		System.out.println(farenheitToCelcius(50.0));
		System.out.println(kelvinToCelcius(0));
		System.out.println(fluidPressure(FluidTable.WATER, 10));
		System.out.println(pressureUnderWater(10));
		System.out.println(kineticEnergy(2,2));
		System.out.println(potentialEnergy(2,5));
		System.out.println(fallSpeed(2.5));
		System.out.println(delta(1,10));
		System.out.println(volumeToMassFluid(FluidTable.WATER,1));
		System.out.println(volumeToMassGas(GasTable.AIR,1));
		System.out.println(volumeToMassSolid(SolidTable.IRON,1));
		System.out.println(svtVelocity(10,5));
		System.out.println(svtDistance(10,5));
		System.out.println(svtTime(10,2));
		System.out.println(work(50,10));
		System.out.println(power(1000,2));
		System.out.println(heatSolid(SolidTable.IRON,1,2));
		System.out.println(heatFluid(FluidTable.WATER,1,10));
		System.out.println(heatGas(GasTable.AIR,1,1));
		System.out.println(velocityToHeight(9.82));
		
		
		
		
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
	public static double volumeToMassFluid(FluidTable fluid, double volume) {
		double volumeToMass = fluid.density*volume;
		return volumeToMass;
	}
	public static double volumeToMassGas(GasTable gas, double volume) {
		double volumeToMass = gas.density*volume;
		return volumeToMass;
	}
	public static double volumeToMassSolid(SolidTable solid, double volume) {
		double volumeToMass = solid.density*volume;
		return volumeToMass;
	}
	public static double svtVelocity(double distance, double time) {
		double Velocity = distance / time;
		return Velocity;
	}
	public static double svtDistance(double velocity, double time) {
		double Distance = velocity*time;
		return Distance;
	}
	public static double svtTime(double distance, double velocity) {
		double time = distance / velocity;
		return time;
	}
	public static double work(double force, double distance) {
		double work = force*distance;
		return work;
	}
	public static double power(double work, double time) {
		double power = work / time;
		return power;
	}
	public static double heatSolid(SolidTable solid, double mass, double deltaT) {
		double heat = solid.heatCapacity * mass * deltaT;
		return heat;
	}
	public static double heatFluid(FluidTable fluid, double mass, double deltaT) {
		double heatFluid = fluid.heatCapacity * mass * deltaT;
		return heatFluid; 
	}
	public static double heatGas(GasTable gas, double mass, double deltaT) {
		double heatGas = gas.heatCapacity * mass * deltaT;
		return heatGas;
	}
	public static double velocityToHeight(double velocity) {
		double velocityToHeight = Math.pow(velocity, 2)/(2*g_swe);
		return velocityToHeight;
	}
	
}

