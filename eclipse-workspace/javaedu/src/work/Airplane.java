package work;
public class Airplane extends Plane {
	Airplane() {
	}
	Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	public void flight(int distance) {
		setFuelSize(getFuelSize()-(distance*3));
	}
}