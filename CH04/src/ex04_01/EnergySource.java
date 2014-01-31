package ex04_01;

public interface EnergySource {

	public boolean empty();
	
	public void fueling(double fuel);
	
	public void charging(double charge);
}
