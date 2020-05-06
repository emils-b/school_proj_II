package school_2;

public class Patient extends AppUser {
	String status;
	int bill = 0;
	int billIncrementationCounter = 0;
	
	
	public Patient(String name, String surname, String status) {
		super(name, surname);
		this.status=status;
		this.id = "PT"+this.id;
		System.out.println("child patient");
	}
	
	void setBill (int amount) {
		int oldBill = this.bill;
		this.bill += amount;
		billIncrementationCounter++;
		System.out.println(this.name+" "+this.surname+" bill was incremented from "+oldBill+" to "+
		this.bill+". This is "+this.billIncrementationCounter+""+ordinalNr(this.billIncrementationCounter)+" time this bill was increased.");
	}
	
	String ordinalNr(int nr) {
		String ord = "";
		if (nr == 1) ord="st";
		else if (nr == 2) ord="nd";
		else if (nr == 3) ord="rd";
		else ord="th";
		return ord;
	}
	
	
	public void changeStatus() {
		int statusListIndex = (int)(Math.random()*(((MainInheritance.patientStatusList.length-1)-0)+1))+0;
		this.status = MainInheritance.patientStatusList[statusListIndex];
		incrementBill();
	}
	
	public void incrementBill() {
		if (this.status.equals("Discharged")) {
			this.setBill(200);
		}
		else if (this.status.equals("Admited")) {
			this.setBill(50);
		}
		else if (this.status.equals("In Transfere")) {
			this.setBill(500);
		}
		else return;
	}
	
	public void printUserInfo() {
		super.printUserInfo();
		System.out.println("Discharge status is "+this.status+" and bill is "+this.bill);
	}
	
	
	
}
