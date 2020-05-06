package school_2;

import java.util.ArrayList;
import java.util.List;

public class MainInheritance {

	static ArrayList<AppUser> appUserList = new ArrayList<AppUser>();
	static ArrayList<Staff> staffList = new ArrayList<Staff>();
	static ArrayList<Patient> patientList = new ArrayList<Patient>();
	static String[] patientStatusList = { "Discharged", "Admited", "In Transfere", "Unknown" };
	static String[] occupationList = { "Nurse", "Doctor", "Orderly" };

	public static void main(String[] args) {
		// AppUser u1 = new AppUser("Janis", "Berzins");
		// Staff s1 = new Staff("Staff1", "St", "Nurse", 700);
		// Patient p1 = new Patient("Patient1", "Pat", "discharged");

		/*
		 * u1.printUserInfo();
		 * System.out.println("________________________________________");
		 * s1.printUserInfo();
		 * System.out.println("________________________________________");
		 * p1.printUserInfo();
		 * System.out.println("________________________________________");
		 * p1.setBill(500);
		 * System.out.println("________________________________________");
		 * p1.printUserInfo();
		 * System.out.println("________________________________________");
		 * p1.setBill(300);
		 */
		createAppUsers(5);
		createStaff(5);
		createPatient(5);
		
		for(Patient p : patientList) {
			p.changeStatus();
		}
		
		for(Patient p : patientList) {
			p.changeStatus();
		}

	}

	public static void createAppUsers(int count) {
		String name = "";
		String surname = "";
		for (int i = 0; i < count; i++) {
			name = getAlphaNumericString(i + (i + 5) / 2);
			surname = getAlphaNumericString(i + (i + 6) / 2);
			AppUser u = new AppUser(name, surname);
			appUserList.add(u);
		}
	}

	public static void createStaff(int count) {
		String name = "";
		String surname = "";
		String occupation = "";
		int salary = 0;
		int occupationIndex = 0;
		for (int i = 0; i < count; i++) {
			if (occupationIndex == occupationList.length-1)
				occupationIndex = 0;
			else
				occupationIndex++;
			name = getAlphaNumericString(i + (i + 5) / 2);
			surname = getAlphaNumericString(i + (i + 6) / 2);
			occupation = occupationList[occupationIndex];
			salary = (int) (Math.random() * 1000);
			Staff u = new Staff(name, surname, occupation, salary);
			staffList.add(u);
		}
	}

	public static void createPatient(int count) {
		String name = "";
		String surname = "";
		String status = "";
		int statusIndex = 0;
		for (int i = 0; i < count; i++) {
			if (statusIndex == patientStatusList.length-1)
				statusIndex = 0;
			else
				statusIndex++;
			status = patientStatusList[statusIndex];
			name = getAlphaNumericString(i + (i + 5) / 2);
			surname = getAlphaNumericString(i + (i + 6) / 2);
			Patient u = new Patient(name, surname, status);
			patientList.add(u);
		}
	}

	
	//lai ģenerētu random String vārdam un uzvārdam
	static String getAlphaNumericString(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
