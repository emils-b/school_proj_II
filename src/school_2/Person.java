package school_2;

public class Person {
	String name;
	int height;
	int iq;
	
	public Person (String name, int height, int iq) {
		this.name=name;
		this.height=height;
		this.iq=iq;
	}
	
	public int getHeihtTimesIq() {
		return this.height*this.iq;
	}

}
