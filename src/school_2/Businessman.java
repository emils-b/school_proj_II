package school_2;

import java.util.ArrayList;

public class Businessman {
	String name;
	int age;
	int monthlySalary;
	ArrayList <Project> projectList;
	static ArrayList<Businessman> bossList = new ArrayList<Businessman>();
	
	public Businessman(String name, int age, int monthlySalary) {
		this.name = name;
		this.age = age;
		this.monthlySalary = monthlySalary;
		projectList = new ArrayList<Project>();
		Businessman.bossList.add(this);
	}
	
	public static Businessman getBestBusinessman() {
		Businessman bestBoss = bossList.get(0);
		int bestBossIncome = 0;
		for (Businessman b : bossList) {
			int income = 0;
			for (Project p : b.projectList) {
				income += p.monthlyProfit;
			}
			if (income>bestBossIncome) {
				bestBossIncome = income;
				bestBoss = b;
			}
		}
		return bestBoss;
	}
	
	public static int getAvarageSalary() {
		int salSumm = 0;
		for (Businessman b:bossList) {
			salSumm+=b.monthlySalary;
		}
		return salSumm/bossList.size();
	}
	
	public int getTotalIncomeFromProj() {
		int ageTilPens = 65 - this.age;
		int monthsTilPens = ageTilPens * 12;
		int totalIncome = 0;
		for (Project p : projectList) {
			totalIncome += p.monthlyProfit*monthsTilPens;
		}
		return totalIncome;
	}
	

}
