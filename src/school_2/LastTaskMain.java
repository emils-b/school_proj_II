package school_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LastTaskMain {
	static String[] colors = {"red", "blue", "black", "white"};
	static ArrayList<FiveOwner> ownerList = new ArrayList<FiveOwner>();

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		System.out.println(First.getMaxCheaterDiff(array));
		ArrayList<Second> objectList = createSecondObjects();
		//Second s = new Second("es", "red");
		for(Second s:objectList) {
			System.out.println(s.toString());
		}
		getThirdObjectWithLimit(2);
		
		Map<String, Fourth> fourthMap = new HashMap<String, Fourth>();
		String[] articleAuthors = {"Steven King","George Clooney","Orge Looney","Orge Looney","Orge Looney","Jim Carrey","World WarZ","Oprah","Me","Me","Vidzemes augstskola","Me","Me","You","That Guy","World War Z","Family Guy","Family Guy","Guy","WillyWonka","Hitler","Hitler","Hitler","World War Z","Līvi","Līvi","Youtube","Vidzemes augstskola","Random word","FamilyGuy","Anonymous","Orge Looney","Orge Looney","Guy","Guy","Willy Wonka","Hitler","World War Z","World War Z","Līvi","OrgeLooney","Jim Carrey","Hitler","Oprah","Orge Looney","Me","George Clooney","Orge Looney"};
		for(String a:articleAuthors) {
			if(!fourthMap.containsKey(a)) {
				Fourth f=new Fourth(a);
				fourthMap.put(a, f);
			}
				fourthMap.get(a).addArticle();
		}
		
		for(String a:fourthMap.keySet()) {
			System.out.println(fourthMap.get(a).name +": "+ fourthMap.get(a).articleCount);
		}
		
		createDogsAndOwners();
		for(FiveOwner o : ownerList) {
			if(o.dog==null) {
				System.out.println(o.name+" doesnt have a dog.");
			}
			else System.out.println(o.name+" pet is "+o.dog.name);
		}
		
	}
	
	public static void createDogsAndOwners() {
		FiveDog dog1 = new FiveDog("Fluff", "pudel", 1);
		FiveDog dog2 = new FiveDog("Flaff", "bulldog", 1);
		FiveDog dog3 = new FiveDog("Fliff", "pudel", 2);
		FiveDog dog4 = new FiveDog("Fleff", "snaucer", 3);
		FiveDog dog5 = new FiveDog("Floff", "random", 4);
		FiveOwner owner1 = new FiveOwner("Jo", 30);
		FiveOwner owner2 = new FiveOwner("Chi", 40);
		FiveOwner owner3 = new FiveOwner("Esri", 50);
		FiveOwner owner4 = new FiveOwner("Steeve", 20);
		FiveOwner owner5 = new FiveOwner("Johny", 25);
		FiveOwner owner6 = new FiveOwner("Johan", 45);
		owner1.getDog(dog1);
		owner2.getDog(dog2);
		owner3.getDog(dog3);
		ownerList.add(owner1);
		ownerList.add(owner2);
		ownerList.add(owner3);
		ownerList.add(owner4);
		ownerList.add(owner5);
		ownerList.add(owner6);
		//System.out.println(owner1.dog.owner.dog.owner.dog.age);
	}
	
	public static ArrayList<Second> createSecondObjects() {
		ArrayList<Second> objectList = new ArrayList<Second>();
		for (int i=0; i<4; i++) {
			String name;
			if (i%2==1) name = ""+(char)(100+i)+(char)(102+i);
			else {
				name = "" + Character.toUpperCase((char)(100+i))+(char)(102+i);
			}
			String color = colors[i];
			Second s = new Second(name, color);
			objectList.add(s);
		}
		return objectList;
	}
	
	public static void getThirdObjectWithLimit(int limit) {
		ArrayList<Third> thirdObjectList = new ArrayList<Third>();
		for (int i=0; i<6; i++) {
			String title = "title"+i;
			int weight = i+1*6;
			int wheels = i+1*2;
			String driverName = "car driver"+i;
			Third t = new Third(title, weight, wheels, driverName);
			thirdObjectList.add(t);
			//System.out.println(title+" "+weight+" "+wheels+" "+driverName);
		}
		for(Third t:thirdObjectList) {
			if (t.getWeightPerWheel()>limit) {
				System.out.println(t.title+" "+t.getDriverName());
			}
		}
	}

}
