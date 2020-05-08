package school_2;

import java.util.ArrayList;

public class LastTaskMain {
	static String[] colors = {"red", "blue", "black", "white"};

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		System.out.println(First.getMaxCheaterDiff(array));
		ArrayList<Second> objectList = createSecondObjects();
		//Second s = new Second("es", "red");
	}
	
	public static ArrayList<Second> createSecondObjects() {
		ArrayList<Second> objectList = new ArrayList<Second>();
		for (int i=0; i<4; i++) {
			String name;
			if (i%2==1) name = ""+(char)(100+i)+(char)(102+i);
			else {
				System.out.println("test");
				name = "" + Character.toUpperCase((char)(100+i))+(char)(102+i);
			}
			String color = colors[i];
			Second s = new Second(name, color);
			objectList.add(s);
		}
		return objectList;
	}

}
