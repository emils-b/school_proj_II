package school_2;

public class FiveOwner {
	String name;
	int age;
	FiveDog dog = null;
	
	public FiveOwner(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void getDog(FiveDog dog) {
		if (this.dog==null) {
			this.dog = dog;
			dog.setOwner(this);
		}
	}

}
