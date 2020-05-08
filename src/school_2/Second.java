package school_2;

public class Second {
	String name;
	int number;
	boolean isAlive;
	String color;
	
	public Second(String name, String color) {
		this.name = name;
		this.color = color;
		this.number = name.length();
		this.isAlive = Character.isUpperCase(name.charAt(0));//isFirstUpperCase();
		System.out.println(toString());
	}
	
	/*
	boolean isFirstUpperCase() {
		boolean isUpperCase = false;
		if (this.name.substring(0,1).equals(this.name.substring(0,1).toUpperCase())) {
			isUpperCase = true;
		}
		return isUpperCase;
	}
	*/
	
	public String toString() {
		String text = this.name + " "+ this.color+" "+this.number+" "+ this.isAlive;
		return text;
	}

}
