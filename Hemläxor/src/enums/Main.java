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
		System.out.println(Uppgift7(1,12,0.5));
		//En nyfödd hundvalp väger 750 gram, med hur mycket kraft dras hundvalpen ner mot jorden?
		System.out.println(Force (0.75));
		//Hur mycket är 500 fahrenheit i grader?
		System.out.println(fahrenheitToCelcius (500));
		//Hur hög hastighet kommer en sten upp i som faller från 10 meter?
		System.out.println(fallSpeed (10));

		
		
		
		
	} 
	/**
	 * Gör om farenheight till celcius
	 * @param farenheit Värdet för temperatur i farenheight
	 * @return värdet i celcius
	 */
	public static double fahrenheitToCelcius (double fahrenheit) {
		double celcius = ((fahrenheit - 32)*5)/9;
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
	 * en viss volym av materia till en massa
	 * @param solid den specifika materian
	 * @param volume Värdet av volymen
	 * @return massan
	 */
	public static double volumeToMassSolid(SolidTable solid, double volume) {
		double volumeToMass = solid.density*volume;
		return volumeToMass;
	}
	/**
	 * räknar ut medelhastigheten med hjälp av sträcka och tid
	 * @param distance den specifika sträckan
	 * @param time den specifika tiden
	 * @return medelhastigheten
	 */
	public static double svtVelocity(double distance, double time) {
		double Velocity = distance / time;
		return Velocity;
	}
	/**
	 * räknar ut sträcka med hjälp av hastighet och tid
	 * @param velocity den specifika hastigheten
	 * @param time den specifika tiden
	 * @return sträckan
	 */
	public static double svtDistance(double velocity, double time) {
		double Distance = velocity*time;
		return Distance;
	}
	/**
	 * räknar ut tid för hjälp av sträcka och hastighet
	 * @param distance den specifika sträckan
	 * @param velocity den specifika hastigheten
	 * @return tiden
	 */
	public static double svtTime(double distance, double velocity) {
		double time = distance / velocity;
		return time;
	}
	/**
	 * räknar ut arbete med hjälp av kraft och sträcka
	 * @param force Värdet av kraften
	 * @param distance den specifika sträckan
	 * @return arbetet
	 */
	public static double work(double force, double distance) {
		double work = force*distance;
		return work;
	}
	/**
	 * räknar ut effekt med hjälp av arbete och tid
	 * @param work Värdet av arbetet
	 * @param time den specifika tiden
	 * @return Effekten
	 */
	public static double power(double work, double time) {
		double power = work / time;
		return power;
	}
	//Glömde skriva på engelska, så gör det i fortsättnignen från och med nu :)
	/**
	 * A method that calculates how much energy it takes to heat a specific material to specific celcius
	 * @param solid The specific material
	 * @param mass The value of the mass
	 * @param deltaT The difference of the time
	 * @return The energy
	 */
	public static double heatSolid(SolidTable solid, double mass, double deltaT) {
		double heat = solid.heatCapacity * mass * deltaT;
		return heat;
	}
	/**
	 * A method that calculates how much energy it takes to heat a specific fluid to specific celcius
	 * @param fluid The specific fluid
	 * @param mass The value of the mass
	 * @param deltaT The difference in time
	 * @return The energy
	 */
	public static double heatFluid(FluidTable fluid, double mass, double deltaT) {
		double heatFluid = fluid.heatCapacity * mass * deltaT;
		return heatFluid; 
	}
	/**
	 * A method that calulates how much energy it takes to heat a specific gas to specific celcius
	 * @param gas The specific gas
	 * @param mass The value of the mass
	 * @param deltaT the difference in time
	 * @return The energy
	 */
	public static double heatGas(GasTable gas, double mass, double deltaT) {
		double heatGas = gas.heatCapacity * mass * deltaT;
		return heatGas;
	}
	/**
	 * A method that calculates how high up a object with a certain velocity can go upwards
	 * @param velocity The specific velocity
	 * @return The height
	 */ 
	public static double velocityToHeight(double velocity) {
		double velocityToHeight = Math.pow(velocity, 2)/(2*g_swe);
		return velocityToHeight;
	}
	/**
	 * A method that transforms mass into force
	 * @param mass the value of the mass
	 * @return The force
	 */
	public static double Force (double mass) {
		double Force = mass*g_swe;
		return Force;
	}
	public static int Uppgift7 (double mass, double h,double mH){
		int studs = 0;



		while ( h > mH) {

		double E = mass* g_swe*h;
		E = E * 0.99;
		h = E/(mass * g_swe);
		studs++;

		}
		return studs;
		}


}

