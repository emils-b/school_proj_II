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
	JLive(){
		this.setTitle("JLive data");
		this.setBounds(300, 50, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JLive.EXIT_ON_CLOSE);
		//this.pack(); //izveido rāmja izmēru tik lielu cik nepieciešams
		createBarChart();
		createLineChart();
		this.pack();
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
		for(int i=0; i<12; i++) {
			lineDataset.addValue(i*5, "Line one", (Integer)i);
		}
	}
	
	void createBarDataset() {
		barDataset = new DefaultCategoryDataset();
		for (int i=0; i<10; i++) {
			barDataset.addValue(i*10 , "Bar " +i , "random data" );
		}
	}

}
