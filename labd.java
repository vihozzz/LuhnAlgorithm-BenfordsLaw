import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.Scanner;
import java.util.concurrent.RejectedExecutionHandler;

class luhndone{
/* 
 * This function is the main program
 * it will print the menu for the customer
 * use number 1-4 and 9 to provide the option to customer
 * according their choice, it will get into the function of the number they typed 
 */
    public static void main(String[]args) {
            String userInput = "";
            String enterCustomerOption = "1";
            String generateCustomerOption = "2";
            String getSalesDataOption = "3";
            String displayGraphOption = "4";
            String exitCondition = "9";
    
            ArrayList<Customer> customers = new ArrayList<>();
            int currentId = 1;
    
            while (!userInput.equals(exitCondition)) {
                printMenu();
                Scanner scanner = new Scanner(System.in);
                userInput = scanner.nextLine();
    
                if (userInput.equals(enterCustomerOption)) {
                    enterCustomerOption(currentId, customers);
                    currentId += 1;
                } else if (userInput.equals(generateCustomerOption)) {
                    generateCustomerDatafile();
                } else if (userInput.equals(getSalesDataOption)) {
                    SalesData();
                } else if (userInput.equals(displayGraphOption)) {
                    DisplayGraph();
                } else {
                    System.out.println("Please type in a valid option (A number from 1-9)");
                }
            }
            System.out.println("Program terminated");
        }
        private static void printMenu() {
            System.out.println("1. Enter Customer Data");
            System.out.println("2. Generate Customer Datafile");
            System.out.println("3. Get Sales Data");
            System.out.println("4. Display Graph");
            System.out.println("9. Exit");
        }
   
    /* 
     * This function is to get the postal code
     * it will ask the customer enter the postal code
     * and check its valid or not
     * when it is not valid, it will
     * print postal code is not valid
     */
    public static String getpostalCode(){
        boolean isPostalValid = false;
        String postalCode = "";
    while (!isPostalValid) {
        System.out.print("Enter customer postal code: ");
        postalCode = ssc.nextLine();
        isPostalValid = validatePostalCode(postalCode);
        if (!isPostalValid) {
            System.out.println("Postal code is not valid!");
        }
      return postalCode;
    }
  }
/* This function is to get the customer info
 * ask the customer enter their information
 * and save the customer information
 */

  public static void enterCustomerInfo(int currentId, ArrayList<Customer> customers) {
    System.out.println("Enter customer first name: ");
    String firstName = sc.nextLine();
    System.out.println("Enter customer last name: ");
    String lastName = sc.nextLine();
    System.out.println("Enter customer city: ");
    String city = sc.nextLine();
    String postalCode = getPostalCode();
    boolean isCCValid = false;
    String creditCardNum = "";
    while (!isCCValid) {
        System.out.print("Enter customer credit card number: ");
        creditCardNum = sc.nextLine();
        isCCValid = validateCreditCard(creditCardNum);
        if (!isCCValid) {
            System.out.println("Credit card number is not valid!");
        }
    }
    // save customer
    String customer = String.format("%d,%s,%s,%s,%s,%s", currentId, firstName, lastName, city, postalCode, creditCardNum);
    customers.add(customer);
  }

  public static boolean validatePostalCode(String postalCode) {
    if (postalCode.length() < 3) {
        return false;
    } else {
        try {
            List<String> postalCodes = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("postal_codes.csv"));
            String line = reader.readLine();
            while (line != null) {
                postalCodes.add(line.split("\\|")[0]);
                line = reader.readLine();
            }
            reader.close();
            if (!postalCodes.contains(postalCode.substring(0, 3))) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
  }

  /* 
   * this function is to check is the credit card validate
   * if the credit card number are less than 9
   * it will return false
   * if it is more than 9, it will reverse the number and check it is odd or even
   * if it is even, number will times 2
   * if the number is bigger than 9, it will split to partial sum
   * if the sum1 + sum2 divided by 10, the digit equal to 0. then the function is true, else it is fault
   */
  public static boolean validateCreditCard(String ccNum){
      if(ccNum.length()<9){
         return false;
      }
      String reverseNum = new StringBuilder(ccNum).reverse().toString();
      int sum1 = 0;
      int sum2 = 0;
      int i = 0;

      if(i < reverseNum.length()){
        int num = Character.getNumericValue(reverseNum.charAt(i));;
        if((i+1)%2){
        int doubled = num * 2;
          if (doubled > 9){
            int partialSum= 0;
            for(char digit: String.valueOf(doubled).toCharArray()){
              partialSum += Character.getNumericValue(digit);
            }
            sum2 += partialSum;
          } 
          else{
            sum2 += doubled;
          }
        }
        else{
          sum1 += num;
        }
        i++;
      }
      return (sum1+sum2) % 10 ==0;
}
/* 
 *  This function is used to save the customer data
 *   Enter the file name means that ask the customer where they want to save their data
 *   file.write means that I ask Customer for their ID, name, city, postal code, credit card number
 *   for customer in customers means that I save the customer data into the customers file
 *  file.close means that I close the file after I save the customer data.
 */
    public static void generateCustomerDatafile(){
        generateCustomerDataFile(); 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String filename = scanner.nextLine();

        try {
            FileWriter file = new FileWriter(filename);
            file.write("Customer ID,First Name,Last Name,City,Postal Code,Credit Card Number\n");

            for (String customer : customers) {
                file.write(customer + "\n");
            }

            file.close();
            System.out.println("File saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

/* 
 * This function is to get the salesData
 * check how many times 1-9 appeared
 * and check the percentage of how many times 1-9 appeared 
 * and it is fraud or not 
 */
 public class salesdt{
    public static void SalesData(){
        try {
          File salesFile = new File("F:\\pythonfile\\sales.csv");
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
          FileWriter writer = new FileWriter("F:\\pythonfile\\results.csv");
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
              }
          }
      }
      finally{
      }
  }
}
/* 
 * This function is to display the sales data graph
 * use jfreechart to display the bar graph
 */
public class graph{
    public static void displayGraph(String applicationTitle, String chartTitle, double[] salesData) {
      DisplayGraph chart = new DisplayGraph(applicationTitle, chartTitle, salesData);
      chart.pack();
      RefineryUtilities.centerFrameOnScreen(chart);
      chart.setVisible(true);
    }
}
 
}
    
   
