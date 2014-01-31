package ex04_01;

public class Battery implements EnergySource {

	private double charge;
	
	@Override
	public void charging(double charge){
		this.charge = charge;
	}
	
	@Override
	public boolean empty() {
		return charge <= 0;
	}
	
	@Override
	public void fueling(double fuel){
		System.out.println("GasTank does not exist.");
	}

}
