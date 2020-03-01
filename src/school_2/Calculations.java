package school_2;

/*
 * ____________________________________________
 * Priekš Full_time_1
 * ____________________________________________
 * 
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Calculations {
	public static void getAvgPopulation(ArrayList<country> countries) {
		List<Long> popList = countries.stream().map(country::getPopulation).collect(Collectors.toList());
		double avg = getAverageFromLongList(popList);
		System.out.println("AVG pop = " +getInMillions(avg)+" mio");
	}
	
	public static void printTopDensest(ArrayList<country> countries, int limit) {
		Collections.sort(countries, new country());
		for (int i=0; i<limit; i++) {
			country c = countries.get(i);
			System.out.println(c.name +": "+c.getPopulation());
		}
	}
	
	public static double getAverageFromLongList(List<Long> list) {
		double sum = 0;
		for (Long a : list) {
			sum += a;
		}
		return sum / list.size();
	}
	
	public static long getInMillions(double num) {
		return (long)(num / 1000000);
	}
	
	public static double round(double num) {
		DecimalFormat df = new DecimalFormat("#,##");      
		return Double.valueOf(df.format(num));
	}
	
	static int getUsableCoastlineCountryRatio(ArrayList<country> countriesList) {
		int count = 0;
		for (country c : countriesList) {
			if (c.hasUsableCoastline())
				count++;
		}
		int noUsableCoastCount = countriesList.size() - count;
		int ratio = getRatio(count, noUsableCoastCount);
		System.out.println(ratio+"% have usable coastline");
		return ratio;
	}
	
	static void printMostPopulatedCountries(ArrayList<country> countriesList, int limit) {
		//Sakārto padoto Country objektu sarakstu pēc defaultā kārtotāja (tā, kas ir Country klasē norādīts compareTo() metodē)
		Collections.sort(countriesList, new DensityComparator());
		System.out.println("Top " +limit+" populated countries");
		for (int i=0; i<countriesList.size() && i<limit; i++) {
			country c = countriesList.get(i);
			System.out.println(c.name + " has "+ getMio(c.population)+" million");
		}
	}
	
	static void printMostDenseCountries(ArrayList<country> countriesList, int limit) {
		//Šeit sakārto sarakstu, norādot atsevišķu salīdzinātāju. Pēc tam arī izvada vajadzīgo skaitu ciklā
		Collections.sort(countriesList, new DensityComparator());
		System.out.println("Top " +limit+" dense countries");
		for (int i=0; i<limit; i++) {
			country c = countriesList.get(i);
			System.out.println(c.name +": "+c.density);
		}
	}
	
	//Palīgmetode, kas atgriež skaitli, pārveidotu miljonos, bet ar 2 cipariem aiz komata.
	static double getMio(long number) {
		double num = number;
		return (double)(Math.round(num / 10000)) / 100;
	}
	
	static int getRatio(double a, double b) {
		return (int)(a / (a + b) * 100);
	}
}
//get those that are top 20 in GDP, Literacy, Phones  (need new lists for these? or myb just c names)
class DensityComparator implements Comparator<country> {
    public int compare(country c1, country c2) {
    	if (c1.density < c2.density) return 1;
		if (c1.density > c2.density) return -1;
		return 0;
    }
}
class LiteracyComparator implements Comparator<country> {
	public int compare(country c1, country c2) {
    	if (c1.literacy < c2.literacy) return 1;
		if (c1.literacy > c2.literacy) return -1;
		return 0;
	}
}

//JFree chart stuff, 
//Some from DB and live things in there - palaist 2 progas - viena liek datus, otra refresho, r�da
//Corelation and more statistics
//try to corelate multiple with EO to get the best