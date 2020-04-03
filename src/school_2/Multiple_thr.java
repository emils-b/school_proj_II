package school_2;

public class Multiple_thr {

	public static void main(String[] args) {
		//new DataLoader(50, 100);
		int productSellIteration = 50;
		int productRefillAfterIterations = 100;
		int chartDataRepaintIteration = 500;
		new JLive(productSellIteration,productRefillAfterIterations,chartDataRepaintIteration  );

	}

}
