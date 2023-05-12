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

  public static  validateCreditCard(String ccNum){
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
}
       
