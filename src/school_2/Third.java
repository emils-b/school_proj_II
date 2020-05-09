package school_2;

public class Third {
	String title;
	int weight;
	int wheels;
	String driverName;
	
	public Third(String title, int weight, int wheels, String driverName) {
		this.title = title;
		this.weight = weight;
		this.wheels = wheels;
		this.driverName = driverName;
	}
	
	int getWeightPerWheel() {
		int weigthtPerWheel;
		weigthtPerWheel = this.weight/this.wheels;
		return weigthtPerWheel;
	}
	
	String getDriverName() {
		String nameFirstUpper = "";
		String name = this.driverName.split(" ")[0].toLowerCase();
		nameFirstUpper = name.substring(0,1).toUpperCase()+name.substring(1);		
		return nameFirstUpper;
	}

}
