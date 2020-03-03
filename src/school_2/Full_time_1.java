package school_2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Full_time_1 {
	static ArrayList<country> countriesList = new ArrayList<country>();
	static HashMap<String, country> countriesMap = new HashMap<String, country>(); 
	
	public static void main(String[] args) {
		String fileUrl = "D:\\Eclipse\\workspace\\school_2\\Countries of the world.csv";
		readCountries(fileUrl);
		
		//Calculations.getAvgPopulation(countriesList);
		//Calculations.printTopDensest(countriesList, 10);
		
		//Izsauc dažādas aprēķinu metodes.
		//Metodes izsauc konkrēti pašai klasei, nevis kādam objektam
		//Lai varētu izsaukt metodes klasei, konkrētajām metodēm jābūt ar atslēgvārdu static
			//Calculations.getUsableCoastlineCountryRatio(countriesList);
			Calculations.printMostPopulatedCountries(countriesList, 10);
			//Calculations.printMostDenseCountries(countriesList, 20);
			//Calculations.printTopDensest(countriesList,5);

	}
	
	/*
	 Nolasa csv failu.
	 Lasa to pa rindām, izlaižot pirmās piecas.
	 Katru rindu sadala pēc atdalītāja ";", iegūstot vērtību masīvu
	 Masīvu padod Country() konstruktoram, no kura izveidojas objekts
	 Objekta referenci ieliek 2 sarakstos.
	 */
	
	static void readCountries(String filename) {
		try {
			File file = new File(filename);
			Scanner read = new Scanner(file);
			int i = 0;
			while (read.hasNextLine()) {
				i++;
				String row = read.nextLine();
				if (i<6) continue;
				String[] data = row.split(";");
				country c = new country(data);
				countriesList.add(c);
				countriesMap.put(c.name, c);
				
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}
	
	/*static void readCountries(String filename) {
		try {
			int i = 0;
			File file = new File(filename);
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) {
				i++;
				String data = read.nextLine();
				if (i<6) continue;
				String[] row = data.split(";");
				//System.out.println(row[0].trim() +" has " +row[2]+" people");
				countries.add(new country(row));
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}*/
	/*static void readCountries(String filename) {
		try {
			File file = new File(filename);
			Scanner read = new Scanner(file);
			int i = 0;
			while (read.hasNextLine()) {
				i++;
				String row = read.nextLine();
				if (i<6) continue;
				String[] data = row.split(";");
				new country(data);
				//System.out.println(data[0].trim()+" has " +data[2] +" p�pl");
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}*/
}
