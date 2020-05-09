package school_2;

public class FiveDog {
	String name;
	String type;
	int age;
	FiveOwner owner;
	
	public FiveDog(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	void setOwner(FiveOwner owner) {
		this.owner = owner;
	}

}
