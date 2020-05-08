package school_2;

public class First {

	public static int getMaxCheaterDiff(int[] array) {
		int max = array[0];
		int sum = 0;
		int med;
		int diff;
		for (int i:array) {
			if(i>max)max=i;
			sum+=i;
		}
		med = sum/array.length;
		diff = max-med;
		return diff;
	}
}
