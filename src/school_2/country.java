package school_2;

import java.util.Comparator;

/*
 * ____________________________________________
 * Priekš Full_time_1
 * ____________________________________________
 * 
 */

//Implementē Comparable interfeisu, kas norāda, pēc kā tiks salīdzināti objekti Collections.sort() metodē
public class country implements Comparator<country> {
	String name;
	String region;
	long population;
	double density;
	double coastline;
	double literacy;
	double area;
	double gdp;
	private double usableCoastlineLimit = 1;
	
	public country() {};
	
	public country(String[] data) {
		this.name = data[0].trim();
		this.region = data[0].split(";")[1].trim(); //jāpārbauda vai darbojās
		this.population = Long.parseLong(data[2]);
		this.density = badStringToDouble(data[4]);
		this.coastline = badStringToDouble(data[5]);
		this.literacy = badStringToDouble(data[9]);
		this.area = badStringToDouble(data[3]);
		this.gdp = badStringToDouble(data[8]);
	}
	public boolean hasCoastline() {
		return this.coastline > 0;
	}
	
	public boolean hasUsableCoastline() {
		return this.coastline > usableCoastlineLimit;
	}
	
	public long getPopulation() {
		return this.population;
	}

	
	static long getLongFromString(String val) {
		if (val==null || val.length()==0) return 0;
		val = val.replace(",", ".");
		return Long.parseLong(val);
	}
	
	static double getDoubleFromString(String val) {
		if (val==null || val.length()==0) return 0;
		val = val.replace(",", ".");
		return Double.parseDouble(val);
	}	
	
	public double badStringToDouble (String num) {
		if (num==null || num.length()==0) return 0;
		num = num.replace(",", ".");
		return Double.parseDouble(num);
	}
	
	//Metode vajadzīga Collections.sort() metodei. Šeit tiek norādīts, pēc kā Country objekti tiks kārtoti.
		//Šeit tiek pārrakstīta esoša (by default Comaprable interfeisam) metode compareTo()
		//Pozitīvs skaitlis nozīmē, ka šis objekts būs sarakstā augstāk, negatīvs - zemāk nekā tas objekts, ar ko salīdzina
	@Override
	public int compare(country c1, country c2) {
		if (c1.getPopulation() > c2.getPopulation()) return -1;
		if (c1.getPopulation() < c2.getPopulation()) return 1;
		return 0;
	}
}
