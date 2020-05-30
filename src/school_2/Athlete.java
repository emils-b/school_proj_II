package school_2;

import java.util.ArrayList;

public class Athlete {
	String name;
	int lengthInCm;
	String country;
	ArrayList<Integer> jumpsInMeter;
	static ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
	
	public Athlete (String name, int lengthInCm, String country) {
		this.name = name;
		this.lengthInCm = lengthInCm;
		this.country = country;
		this.jumpsInMeter = new ArrayList<Integer>();
		Athlete.athleteList.add(this);
	}
	
	public void addNewJump(int newJump) {
		this.jumpsInMeter.add(newJump);
	}
	
	//atrod labāko sportistu
	public static void getBestJumper() {
		Athlete bestAthlete = athleteList.get(0);
		int bestAthletesBestJump = 0;
		for (Athlete a:athleteList) {
			int bestJump = 0;
			for (int j:a.jumpsInMeter) {
				if (j>bestJump) bestJump = j;
			}
			if (bestJump > bestAthletesBestJump) {
				bestAthletesBestJump = bestJump;
				bestAthlete = a;
			}
			if (bestJump == bestAthletesBestJump) {
				if (bestAthlete.lengthInCm>a.lengthInCm) {
					bestAthletesBestJump = bestJump;
					bestAthlete = a;
				}
			}
		}
		System.out.println("Best Athlete is: "+bestAthlete.name);
	}

}
