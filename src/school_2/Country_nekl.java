package school_2;

public class Country_nekl {
	String name;
	double gdp;
	double population;
	double coastline;
	
	public Country_nekl(String[] array) {
		this.name = array[0].trim();
		this.gdp = stringToDouble(array[8]);
		this.population = stringToDouble(array[2]);
		this.gdp = stringToDouble(array[5]);
		System.out.println(this.name+" created");
	}
	
	private double stringToDouble(String elem) {
		if (elem.length()==0) return 0;
		elem = elem.replace(",", ".");
		return Double.parseDouble(elem);
	}

}
