package school_2;

import java.util.Comparator;

/*
 * ____________________________________________
 * Priekš Full_time_1
 * ____________________________________________
 * 
 */

//Implementē Comparable interfeisu, kas norāda, pēc kā tiks salīdzināti objekti Collections.sort() metodē
//******************************************************
//kādēļ šis interfeiss te jāliek? tas ir kāds defoultais, jo atsevišķšs interfeiss nav veidots?
//*******************************************************
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
	double gdpToPop;
	double phonesPer1000;
	double netMigration;
	double infantMortality;
	double arable;
	double crops;
	double other; //???
	double climate;
	double birthrate;
	double deathrate;
	double agriculture;
	double industry;
	double service;
	
	public country() {};
	
	/*
	 * Jāizveido, ka 6 uzdevumam caur objekta ielasīšanu veido String arraylist, kurā tad ir konkrētais parametrs this.gdp piem
	 * un to tad caur konstruktoru liek iekšā
	 */
	public country(String[] data) {
		this.name = data[0].trim();
		this.region = data[1].trim();
		//this.population = Long.parseLong(data[2]);
		this.population = badStringToLong(data[2]);
		this.area = badStringToDouble(data[3]);
		this.density = badStringToDouble(data[4]);
		this.coastline = badStringToDouble(data[5]);
		this.netMigration = badStringToDouble(data[6]);
		this.infantMortality = badStringToDouble(data[7]);
		this.gdp = badStringToDouble(data[8]);
		this.literacy = badStringToDouble(data[9]);
		this.phonesPer1000 = badStringToDouble(data[10]);
		this.arable = badStringToDouble(data[11]);
		this.crops = badStringToDouble(data[12]);
		this.other = badStringToDouble(data[13]);
		this.climate = badStringToDouble(data[14]);
		this.birthrate = badStringToDouble(data[15]);
		this.deathrate = badStringToDouble(data[16]);
		this.agriculture = badStringToDouble(data[17]);
		this.industry = badStringToDouble(data[18]);
		this.service = badStringToDouble(data[19]);
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
	//**********************************
	//kādēļ šajos , nomaina uz .?
	//***********************************
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
	
	public long badStringToLong (String num) {
		if (num==null || num.length()==0) return 0;
		num = num.replace(",", ".");
		return Long.parseLong(num);
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
