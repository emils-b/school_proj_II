package school_2;

public class Staff extends AppUser {
	String occupation;
	int salary;
	
	
	public Staff(String name, String surname, String occupation, int salary) {
		super(name, surname);
		this.occupation = occupation;
		this.id = this.occupation.substring(0,2).toUpperCase()+this.id;
		this.salary = salary;
		System.out.println("child staff");
	}
	
	public void printUserInfo() {
		super.printUserInfo();
		System.out.println("Occupation is "+this.occupation+" and salary is "+this.salary);
	}
	
	
}
