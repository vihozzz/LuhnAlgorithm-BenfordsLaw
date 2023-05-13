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

 class labd{
    public static void main(String[]args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        if (validateCreditCard(ccNum)){
          System.out.println("Credit card number is valid");
        }
        else{
          System.out.println("Credit Card number is not valid");
        }
        sc.close();
    }

  public static int validateCreditCard(String ccNum){
      if(ccNum.length()<9){
         ccNum = false;
      }
      String reverseNum = new String(ccNum).reverse() .toString();
      int sum1 = 0;
      int sum2 = 0;
      int i = 0;

      if(i < reverseNum.length()){
        int num = reverseNum.charAt(i);
        if((i+1)%2){
        int doubled = num * 2;
          if (doubled > 9){
            int partialSum= 0;
            for(char digit: String(doubled).toCharArray){
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
          i++;
        }
        return (sum1+sum2) % 10 ==0;
        System.out.println(validateCreditCard());
      }
    }
    public static void generateCustomerDatafile(){
        generateCustomerDataFile(); 
        Scanner scanner = new Scanner(System.in);
        String csvFile = "postal_codes.csv";
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
 

    public static void mainprogram(String[] args){
      String userInput = "";
        String enterCustomerOption = "1";
        String generateCustomerOption = "2";
        String exitCondition = "9";

        ArrayList<Customer> customers = new ArrayList<>();
        int currentId = 1;

      if(!userInput.equals(exitCondition())){
          printMenu();
          userInput = Scanner.nextilne();
        }
        if(userInput.euqals(enterCustomerOption())){
          enterCustomerOption(currentId);
          currentId +=1;
        }
        else if(userInput.equals(generateCustomerOption())){
          generateCustomerDatafile();
        }
        else{
          System.out.println("Please type in a valid option (A number from 1-9)");
        }
      System.out.println("program terminated");
  }
}
    
   
