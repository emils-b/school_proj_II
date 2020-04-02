package school_2;

public class thread {

	public static void main(String[] args) {
		int i=0;
		two();
		do {
			System.out.println("ONE => " +1);
			pause(500);
			i++;
		} while (i<10000);

	}
	
	static void two() {
		Thread th = new Thread() {
			public void run() {
				int i=0;
				do {
					System.out.println("TWO => " +i);
					pause(300);
					i++;
				}while(true);
			}
		};
		th.start();
	}
	
	static void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			
		}
	}
	

}
