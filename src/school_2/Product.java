package school_2;

import java.util.ArrayList;

public class Product {
	String name;
	int stock;
	int startStock;
	ArrayList<Integer> stockChanges;
	
	Product(String name, int stock){
		this.name = name;
		this.stock = stock;
		this.startStock = this.stock;
		this.stockChanges = new ArrayList<Integer>();
		this.stockChanges.add(this.stock);
	}
	
	void sell (int amount) {
		if (amount > this.stock) {
			amount = this.stock;
		}
		this.stock -= amount;
		this.stockChanges.add(stock);
	}
	
	void refillStock(int amount) {
		if (amount > this.stock) {
		this.stock = amount;
		}
		System.out.println(this.name+" refill to "+this.stock+" from max " +this.startStock);
	}
	
	public String toString() {
		return this.name+" has "+this.stock + " int stock";
	}

}
