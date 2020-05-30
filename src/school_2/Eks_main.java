package school_2;

public class Eks_main {

	public static void main(String[] args) {
		//Pirmais uzdevums
		int limit = 5;
		String string1 = "TeStINgSTRINGONE";
		String string2 = "testStRINGTwO";
		System.out.println(uppercaseLimitCount(limit, string1, string2));
		String string3 = "TeStI";
		String string4 = "test";
		System.out.println(uppercaseLimitCount(limit, string3, string4));
		String string5 = "TESTSTRING";
		String string6 = "TESTSTRING";
		System.out.println(uppercaseLimitCount(limit, string5, string6));
		
		//Otrais uzdevums
		System.out.println("_____Otrais uzdevums_____");
		Athlete athlete1 = new Athlete("name1", 180, "Country1");
		Athlete athlete2 = new Athlete("name2", 185, "Country2");
		Athlete athlete3 = new Athlete("name3", 189, "Country3");
		Athlete athlete4 = new Athlete("name4", 175, "Country4");
		Athlete athlete5 = new Athlete("name5", 179, "Country5");
		addJumpsToAthlete();
		Athlete.getBestJumper();
		
		//Trešais uzdevums
		System.out.println("_____Trešais uzdevums____");
		Businessman businessman1 = new Businessman("Boss1", 40, 4000);
		Businessman businessman2 = new Businessman("Boss2", 50, 4500);
		Businessman businessman3 = new Businessman("Boss3", 45, 3300);
		Businessman businessman4 = new Businessman("Boss4", 60, 5000);
		Project project1 = new Project("Project1", 10000, 5, businessman1);
		Project project2 = new Project("Project2", -100, 2, businessman1);
		Project project3 = new Project("Project3", 5000, 10, businessman1);
		Project project4 = new Project("Project4", 110000, 9, businessman2);
		Project project5 = new Project("Project5", -100000, 6, businessman2);
		Project project6 = new Project("Project6", -10000, 2, businessman3);
		Project project7 = new Project("Project7", 440000, 15, businessman3);
		Project project8 = new Project("Project8", 330000, 10, businessman3);
		Project project9 = new Project("Project9", 10000, 5, businessman4);
		Project project10 = new Project("Project10", 15000, 6, businessman4);
		Project project11 = new Project("Project11", 100000, 8, businessman4);
		System.out.println("testing connections "+businessman1.projectList.get(2).name);
		System.out.println("testing connections "+businessman2.projectList.get(1).boss.name);
		System.out.println("Avarage salary is: "+Businessman.getAvarageSalary());
		System.out.println("Best boss is: "+Businessman.getBestBusinessman().name);
		System.out.println("Income til pension for "+businessman1.name+" is: " + businessman1.getTotalIncomeFromProj());
		System.out.println("Income til pension for "+businessman2.name+" is: " + businessman2.getTotalIncomeFromProj());
		
	}
	//pirmā uzdevuma galvenā metode
	public static String uppercaseLimitCount(int limit, String string1, String string2) {
		System.out.println("________Pirmais uzdevums______");
		String limitNotReached = "undefined";
		int string1Counter = getsUpperCaseCount(string1);
		int string2Counter = getsUpperCaseCount(string2);
		if (string1Counter<limit || string2Counter<limit) return limitNotReached;
		else if (string1Counter>string2Counter) return string1;
		else if (string1Counter==string2Counter) return "Equal length strings";
		else return string2;
	}
	
	//pirmā uzdevuma palīgmetode
	public static int getsUpperCaseCount(String string) {
		int count = 0;
		String[] stringArr = string.split("");
		for (String c:stringArr) {
			if (c.equals(c.toUpperCase())) count++;
			}
		return count;
	}
	
	//otrā uzdevuma lēcienu veidošana
	public static void addJumpsToAthlete() {
		System.out.println("Adding jumps to Athletes");
		for (Athlete a:Athlete.athleteList) {
			for (int i = 0; i<5; i++) {
			int jump = 1 + (int)(Math.random() * ((8 - 1) + 1));
			a.addNewJump(jump);
			}
		}
	}
	
	

}
