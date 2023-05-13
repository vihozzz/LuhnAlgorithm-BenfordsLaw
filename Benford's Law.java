import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.Scanner;

public class SalesData {
    public static void main(String[] args) {
        try {
            File salesFile = new File("C:\\Assignment\\Sales\\sales.csv");
            Scanner salesScanner = new Scanner(salesFile);
            String[] salesData = new String[salesScanner.nextLine().split(",").length];
            int i = 0;
            while (salesScanner.hasNextLine()) {
                String[] line = salesScanner.nextLine().split(",");
                salesData[i] = line[1];
                i++;
            }
            salesScanner.close();
            int[] digitalResult = new int[9];
            double[] benfordLawResult = new double[9];
            int count = salesData.length;
            for (int j = 0; j < salesData.length; j++) {
                String firstDigit = salesData[j].substring(0, 1);
                int num = Integer.parseInt(firstDigit);
                digitalResult[num - 1] += 1;
            }
            for (int k = 0; k < digitalResult.length; k++) {
                benfordLawResult[k] = 100 * digitalResult[k] / count;
            }
            if (benfordLawResult[0] < 29 || benfordLawResult[0] > 32) {
                System.out.println("This sales data is a fraud");
                System.exit(0);
            }
            FileWriter writer = new FileWriter("C:\\Assignment\\Sales\\results.csv");
            writer.append("Digit");
            writer.append(",");
            writer.append("Percent");
            writer.append("\n");
            for (int l = 0; l < benfordLawResult.length; l++) {
                writer.append(String.valueOf(l + 1));
                writer.append(",");
                writer.append(String.valueOf());
                
                public class DisplayGraph extends ApplicationFrame {

                    public DisplayGraph(String applicationTitle, String chartTitle, double[] salesData) {
                        super(applicationTitle);
                        JFreeChart barChart = ChartFactory.createBarChart(
                                chartTitle,
                                "Digit",
                                "Percent",
                                createDataset(salesData),
                                PlotOrientation.VERTICAL,
                                true, true, false);
                
                        ChartPanel chartPanel = new ChartPanel(barChart);
                        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
                        setContentPane(chartPanel);
                    }
                
                    private DefaultCategoryDataset createDataset(double[] salesData) {
                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        String[] digitLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
                        String[] barLabels = new String[9];
                        for (int i = 0; i < 9; i++) {
                            barLabels[i] = digitLabels[i] + " = " + String.format("%.1f", salesData[i]) + "%";
                            dataset.addValue(salesData[i], barLabels[i], digitLabels[i]);
                        }
                        return dataset;
                    }
                
                    public static void displayGraph(String applicationTitle, String chartTitle, double[] salesData) {
                        DisplayGraph chart = new DisplayGraph(applicationTitle, chartTitle, salesData);
                        chart.pack();
                        RefineryUtilities.centerFrameOnScreen(chart);
                        chart.setVisible(true);
                    }
                }
            }
        }finally{}
        reader.close();

    }
}