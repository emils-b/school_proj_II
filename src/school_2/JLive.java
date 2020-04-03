package school_2;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class JLive extends JFrame {
	DefaultCategoryDataset barDataset;
	DefaultCategoryDataset lineDataset;
	DataLoader dataLoader;
	
	JLive(int ticks, int refill, int refreshChart){
		this.dataLoader = new DataLoader(ticks, refill);
		this.setTitle("JLive data");
		this.setBounds(300, 50, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JLive.EXIT_ON_CLOSE);
		//this.pack(); //izveido rāmja izmēru tik lielu cik nepieciešams
		//createBarChart();
		createLineChart();
		this.pack();
		int tick = 1;
		do {
			pause(refreshChart);
			//updateBarChart();
			updateLineChart();
			tick++;
		}while(true);
	}
	
	void createLineChart() {
		createLineDataset();
		JFreeChart lineChart = ChartFactory.createLineChart(
				"Products", "Days", "Product count", lineDataset, PlotOrientation.VERTICAL, true, false, true);
		ChartPanel chartPanel = new ChartPanel(lineChart);
		this.setContentPane(chartPanel);
	}
	
	void createBarChart() {
		createBarDataset();
		JFreeChart barChart = ChartFactory.createBarChart(
				"The bar stuff", "Type", "Counts", this.barDataset, PlotOrientation.VERTICAL, true, false, true);
		ChartPanel chartPanel = new ChartPanel(barChart);
		this.setContentPane(chartPanel);
	}
	
	void createLineDataset() {
		lineDataset = new DefaultCategoryDataset();
		for(int i=0; i<dataLoader.products.size(); i++) {
			Product p = dataLoader.products.get(i);
			lineDataset.addValue(p.stock, p.name, (Integer)0);
		}
	}
	
	void createBarDataset() {
		barDataset = new DefaultCategoryDataset();
		for (int i=0; i<dataLoader.products.size(); i++) {
			Product p = dataLoader.products.get(i);
			barDataset.addValue(p.stock , p.name , "stock data" );
		}
	}
	
	void pause (int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {	
		}
	}
	
	void updateLineChart() {
		int num = dataLoader.products.get(0).stockChanges.size();
		if (lineDataset.getColumnCount()>30) {
			lineDataset.removeColumn(0);
		}
		for(int i=0; i<dataLoader.products.size(); i++) {
			Product p = dataLoader.products.get(i);
			lineDataset.addValue(p.stock, p.name, (Integer)num);
		}
	}
	
	void updateBarChart() {
		barDataset.clear();
		for (int i=0; i<dataLoader.products.size(); i++) {
			Product p = dataLoader.products.get(i);
			barDataset.addValue(p.stock, p.name, "stock data");
		}
	}
}
