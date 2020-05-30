package school_2;

public class Project {
	String name;
	int monthlyProfit;
	int involvedPersonsCount;
	Businessman boss;
	
	public Project (String name, int monthlyProfit, int involvedPersonsCount, Businessman boss) {
		this.name = name;
		this.monthlyProfit = monthlyProfit;
		this.involvedPersonsCount = involvedPersonsCount;
		this.boss = boss;
		this.boss.projectList.add(this);
	}

}
