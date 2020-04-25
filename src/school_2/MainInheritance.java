package school_2;

public class MainInheritance {

	public static void main(String[] args) {
		AppUser u1 = new AppUser("Janis", "Berzins");
		Staff s1 = new Staff("Staff1", "St", "Nurse", 700);
		Patient p1 = new Patient("Patient1", "Pat", "discharged");
		
		u1.printUserInfo();
		System.out.println("________________________________________");
		s1.printUserInfo();
		System.out.println("________________________________________");
		p1.printUserInfo();
		System.out.println("________________________________________");
		p1.setBill(500);
		System.out.println("________________________________________");
		p1.printUserInfo();
		System.out.println("________________________________________");
		p1.setBill(300);
		

	}

}
