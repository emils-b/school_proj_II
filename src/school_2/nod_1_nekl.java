package school_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class nod_1_nekl {

	
	static ArrayList<Country_nekl> countries = new ArrayList<Country_nekl>();
	
	
	public static void main(String[] args) {
		/* geterus un seterus izmanto, lai piem veidotu logout, ka birth rate tiek mainīts
		 * 
		 * void setBirthrate(long newBirthrate){
		 * System.out.println("old birth rate changed to: "+newNirthrate);
		 * this.birthrate=newBirthrate:
		 * }
		 * 
		 * var arī metodē likt citas lietas, piem if steitmentu, kas limitē cik bieži var mainīt vērtību
		 * vispārīgi tad var likt visādas papild funkcijas, kuras darbotos parametra mainīšanas gadījumā
		 */
		
		String fileUrl = "D:\\Eclipse\\workspace\\school_2\\Countries of the world.csv";
		readCountries(fileUrl);
		
		double avgGDP = 0;
		double totalGDP = 0;
		int noCoastCount = 0;
		
		for (Country_nekl c:countries) {
			totalGDP +=c.gdp;
			if(c.coastline==0) noCoastCount++;
		}
		avgGDP = totalGDP / countries.size();
		System.out.println(avgGDP);
		System.out.println(noCoastCount+ " countries don't have coastline");
		
	}
	
	static void readCountries(String url) {
		try {
			File file = new File(url);
			Scanner read = new Scanner(file);
			int i=0;
			while (read.hasNextLine()) {
				String row = read.nextLine();
				i++;
				if (i<6) continue;
				//System.out.println(row);
				String[] data = row.split(";");
				Country_nekl c = new Country_nekl(data);
				countries.add(c);
				//System.out.println(data[0].trim());
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Sumtin wen rong");
			e.printStackTrace();
		}
	}

}
