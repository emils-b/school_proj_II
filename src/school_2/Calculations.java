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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Calculations {
	//*****************************************
	//neizprotu kā šis strādā, pamatā popList
	//*****************************************
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
	
	//**************************************************
	//return sintakse nav skaidra, kādēļ long ir iekavās?
	//***************************************************
	public static long getInMillions(double num) {
		return (long)(num / 1000000);
	}
	
	//***********************************************************************
	//ja pareizi saprotu šis liek izveidot decimālo formātu pēc konkrēta veida?
	//***********************************************************************
	public static double round(double num) {
		DecimalFormat df = new DecimalFormat("#,##");      
		return Double.valueOf(df.format(num)); //pārveido skaitli uz double pēc konkrētā forma'ta
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
		                                                  //**********************************************************************************
		Collections.sort(countriesList, new country()); //kas te tiek rakstīts iekavās un pēc kāda pricipa, jo bez country ir errors?
		System.out.println("Top " +limit+" populated countries"); //******************************************************************
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
	
	//manis pievienots
	//******************
	static void printCountriesWithBigestGdp(ArrayList<country> countriesList, int limit) {
		Collections.sort(countriesList, new GdpComparator());
		System.out.println("Top " +limit+" bigest GDPs");
		for (int i=0; i<limit; i++) {
			country c = countriesList.get(i);
			System.out.println(c.name +": "+c.gdp);
		}
	}
	
	//jau ir norādīts gdp per capita tabulā, tā kā šis aprēķins nedod reāli rezultātu
	static void printCountriesWithBigestGdpToPopulation(ArrayList<country> countriesList, int limit) {
		for (country c:countriesList) {
			c.gdpToPop = getPopulationGdpRatio(c.population, c.gdp);
		}
		Collections.sort(countriesList, new GdpToPopRatioComparator());
		for (int i=0; i<limit; i++) {
			country c = countriesList.get(i);
			System.out.println(c.name + " has bigest GDP to population ratio of: "+Math.round(c.gdpToPop*100.0)/100.0);
		}
	}
	
	static double getPopulationGdpRatio(long pop, double gdp) {
		return gdp/pop;
	}
	
	static Set<String> getCountriesWithTopLiteracy(ArrayList<country> countriesList, int limit) {
		Set<String> listTopCountries = new HashSet<String>();
		Collections.sort(countriesList, new LiteracyComparator());
		for (int i=0; i<limit; i++) {
			listTopCountries.add(countriesList.get(i).name);
		}
		return listTopCountries;
	}
	
	static Set<String> getCountriesWithTopPhonePerCap(ArrayList<country> countriesList, int limit) {
		Set<String> listTopCountries = new HashSet<String>();
		Collections.sort(countriesList, new phonesPer1000Comparator());
		for (int i=0; i<limit; i++) {
			listTopCountries.add(countriesList.get(i).name);
		}
		return listTopCountries;
	}
	
	static Set<String> getCountriesWithBigestGdp(ArrayList<country> countriesList, int limit) {
		Set<String> listTopCountries = new HashSet<String>();
		Collections.sort(countriesList, new GdpComparator());
		for (int i=0; i<limit; i++) {
			listTopCountries.add(countriesList.get(i).name);
		}
		return listTopCountries;
	}
	
	static void printCountriesTopInGdpLiteracyPhones(ArrayList<country> countriesList, int limit) {
		ArrayList<String> countryList = new ArrayList<String>();
		System.out.println("Among Top "+limit+" countries in Literacy, Phone per capita and GDP are:");
		Set<String> topGdp = getCountriesWithTopLiteracy(countriesList, limit);
		Set<String> topPhonePerCap = getCountriesWithTopPhonePerCap(countriesList, limit);
		Set<String> topLit = getCountriesWithTopLiteracy(countriesList, limit);
		int i=1;
		for (country c:countriesList) {
			if (topGdp.contains(c.name)&&topPhonePerCap.contains(c.name)&&topLit.contains(c.name)) {
				countryList.add(i+" "+c.name);
				i++;
			}
		}
		for(String c:countryList) {
			System.out.println(c);
		}
	}
	
	static ArrayList<Double> makeAreaList(ArrayList<country> countriesList){
		ArrayList<Double> first = new ArrayList<Double>();
		for (country c: countriesList) {
			first.add(c.area);
		}
		return first;
	}

	static ArrayList<Double> makeGdpList(ArrayList<country> countriesList){
		ArrayList<Double> sec = new ArrayList<Double>();
		for (country c: countriesList) {
			sec.add(c.gdp);
		}
		return sec;
	}
	
	static double getCorellationRateFromLists(ArrayList<Double> first, ArrayList<Double> sec) {
		double ratio = 0;
		if (first==null || sec==null || first.size()!=sec.size()) return ratio;
		int i=0, n=first.size();
		double xSum=0, ySum=0, xySum=0, x2Sum=0, y2Sum=0;
		for (Double xD : first) {
			Double yD = sec.get(i);
			double x = xD.doubleValue();
			double y = yD.doubleValue();
			double xy = x * y;
			double x2 = x * x;
			double y2 = y *y;
			xSum += x;
			ySum += y;
			xySum += xy;
			x2Sum += x2;
			y2Sum += y2;
			i++;
		}
		ratio = (n * xySum - xSum * ySum) / Math.sqrt((n * x2Sum - xSum * xSum) * (n * y2Sum - ySum * ySum));
		ratio = (double) (Math.round(ratio * 100)) / 100;
		return ratio;
	}
	
	//*******************
	
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
//***********************************************************************************************
//sanāk, ka lai collections.sort sakaŗtotu ArrayList secīgi pēc kāda lieluma, tajā iekavās ir jānorāda klase/objekts, 
//kurš parāda pēc kura raksturlieluma kārtot?
//*****************************************************************************************
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

//manis pievienots
//*****************
class GdpComparator implements Comparator<country> {
	public int compare(country c1, country c2) {
    	if (c1.gdp < c2.gdp) return 1;
		if (c1.gdp > c2.gdp) return -1;
		return 0;
	}
}

class GdpToPopRatioComparator implements Comparator<country> {
	public int compare(country c1, country c2) {
    	if (c1.gdpToPop < c2.gdpToPop) return 1;
		if (c1.gdpToPop > c2.gdpToPop) return -1;
		return 0;
	}
}
/*
class literacyComparator implements Comparator<country> {
	public int compare(country c1, country c2) {
    	if (c1.literacy < c2.literacy) return 1;
		if (c1.literacy > c2.literacy) return -1;
		return 0;
	}
}
*/
class phonesPer1000Comparator implements Comparator<country> {
	public int compare(country c1, country c2) {
    	if (c1.phonesPer1000 < c2.phonesPer1000) return 1;
		if (c1.phonesPer1000 > c2.phonesPer1000) return -1;
		return 0;
	}
}


//******************

//JFree chart stuff, 
//Some from DB and live things in there - palaist 2 progas - viena liek datus, otra refresho, r�da
//Corelation and more statistics
//try to corelate multiple with EO to get the best