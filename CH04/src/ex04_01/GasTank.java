package ex04_01;

public class GasTank implements EnergySource {
	private double fuel;
	
	public void fueling(double fuel){
		this.fuel = fuel;
	}
	
	public boolean empty() {
		return fuel <= 0;
	}
	
	public void charging(double charge){
		System.out.println("Battery does not exist.");
	}


}
