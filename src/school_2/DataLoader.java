package school_2;

import java.util.ArrayList;

public class DataLoader {
	static String[] productNames = {"Bananas", "Apples", "Pears", "Water", "Eggs", "Chocolate", "Toilet papper", "MAX"};
	static int[] productStartingStock = {400, 300, 350, 1000, 600, 777, 543, 1200};
	ArrayList<Product> products;
	
	public DataLoader(int tickSize, int refillTime) {
		init();
		Thread thread = new Thread() {
			public void run() {
				runBusiness(tickSize, refillTime);
			}
		};
		thread.start();
	}
	
	void runBusiness(int tickSize, int refillTime) {
		int it = 1;
		do {
			pause(tickSize);
			sellRandomProduct();
			if (it % refillTime == 0) {
				refillStock();
			}
			it++;
		} while(true);
	}
	
	void sellRandomProduct() {
		int pNum = getRandomBetween(0, products.size() - 1);
		int amount = getRandomBetween(1, 10);
		Product p = products.get(pNum);
		p.sell(amount);
		
	}
	
	void refillStock(){
		for (int i=0; i<products.size(); i++) {
			Product p = products.get(i);
			int refillAmount = getRandomBetween((int)((p.startStock-p.stock)*0.7), p.startStock);
			p.refillStock(refillAmount);
		}
	}
	
	int getRandomBetween(int from, int to) {
		int num = (int) Math.round((Math.random() * (to - from))) + from; 
		//Math.random iegūst random skaitli no 0 līdz 1, tad pareizina ar diapazonu, kurā šis skaitlis ir derīgs un pieskaita skaitli no kura šis diapazons sāksies
		return num;
	}
	
	void pause (int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			
		}
		
	}
	
	void init() {
		products = new ArrayList<Product>();
		for (int i=0; i<productNames.length; i++) {
			Product p = new Product(productNames[i], productStartingStock[i]);
			products.add(p);
		}
	}

}
