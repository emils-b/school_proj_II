package school_2;

public class AppUser {
	String name;
	String surname;
	String id;
	final private String appUserId;
	
	
	public AppUser() {
		this.appUserId = getUserId();
		System.out.println("parent1");
	}
	
	public AppUser(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.id = ""+Math.round(Math.random()*100000);
		this.appUserId = getUserId();
		System.out.println("parent2");
	}
	
	private String getUserId() {
		String id = this.name.substring(0,3)+Math.round(Math.random()*1000000)+this.surname.substring(0,2);
		return id;
	}
	
	public String getAppUserId() {
		return this.appUserId;
	}
	
	public void printUserInfo() {
		System.out.println(this.name+" "+this.surname+" id is: "+this.id);
	}
	
}
