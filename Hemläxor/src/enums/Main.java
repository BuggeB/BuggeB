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
		System.out.println(fluidPressure(FluidTable.WATER, 75));
		System.out.println(velocityToHeight (16.667));
		System.out.println(power (work(Force(735),(100 / 3.6 * 4.8)),4.8));
		System.out.println();
		

		
		
		
		
	} 
	/**
	 * Gör om farenheight till celcius
	 * @param farenheit Värdet för temperatur i farenheight
	 * @return värdet i celcius
	 */
	public static double farenheitToCelcius (double farenheit) {
		double celcius = ((farenheit - 32)*5)/9;
		return celcius;
	}
	/**
	 * Gör om Kelvin till Celcius
	 * @param kelvin Värdet för temeratur för Kelvin
	 * @return Värdet i Celcius
	 */
	public static double kelvinToCelcius (double kelvin) {
		double celcius = (kelvin-273.15);
		return celcius;
	}
	/**
	 * Räknar ut vätsketrycket i en viss vätska vid ett visst djup
	 * @param fluid Den specifika vätskan
	 * @param deep Det exakta djupet
	 * @return  Vätsketrycket
	 */
	public static double fluidPressure(FluidTable fluid, double deep) {
		double FluidPressure = 0;
		FluidPressure = fluid.density*g_swe*deep;
		return FluidPressure;	
	}
	/**
	 * Räknar ut vätsketrycket i vatten vid ett visst djup
	 * @param deep Det exakta djupet
	 * @return Vattentrycket
	 */
	public static double pressureUnderWater(double deep) {
		double pressureWaterPressure = FluidTable.WATER.density*g_swe*deep;
		return pressureWaterPressure;
	}
	/**
	 * räknar ut kinetisk energi med hjälp av massa och hastighet
	 * @param mass Värdet för massan
	 * @param velocity Värdet för hastigheten
	 * @return Den kinetiska energin
	 */
	public static double kineticEnergy(double mass, double velocity) {
		double kineticEnergy = 0.5*mass*Math.pow(velocity, 2);
		return kineticEnergy;
	}
	/**
	 * räknar ut potentiell energi med hjälp av massa och höjd
	 * @param mass Värdet för massan
	 * @param height Värdet för höjden
	 * @return den potentiella energin
	 */
	public static double potentialEnergy(double mass, double height) {
		double potentialEnergy = mass*g_swe*height;
		return potentialEnergy;
	}
	/**
	 * räknar ut hur hög hastighet man kommer upp i som man släpper ett föremål från en viss höjd
	 * @param height Värdet för höjden
	 * @return Hastigheten
	 */
	public static double fallSpeed(double height) {
		double speed = Math.sqrt(2*g_swe*height);
		return speed;
	}
	/**
	 * räknar ut skillnad mellan två givna värden
	 * @param first första värdet
	 * @param last andra värdet
	 * @return skillnaden mellan värdena
	 */
	public static double delta(double first, double last) {
		double difference = last - first;
		return difference;
	}
	/**
	 * gör om en viss volym av vätska till en massa
	 * @param fluid den specifika vätskan
	 * @param volume Värdet av volymen
	 * @return massan
	 */
	public static double volumeToMassFluid(FluidTable fluid, double volume) {
		double volumeToMass = fluid.density*volume;
		return volumeToMass;
	}
	/**
	 * gör om en viss volym av gas till en massa
	 * @param gas den specifika gasen
	 * @param volume Värdet av volymen
	 * @return massan
	 */
	public static double volumeToMassGas(GasTable gas, double volume) {
		double volumeToMass = gas.density*volume;
		return volumeToMass;
	}
	/**
	 * 
	 * @param solid
	 * @param volume
	 * @return
	 */
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
	public static double Force (double mass) {
		double Force = mass*g_swe;
		return Force;
	}
	
}

