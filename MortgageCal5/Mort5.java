/*In this Iteration 5: 
 * I have 
 *  1. Generalized the Input Method
Replaced the hardcoded readNumber(String prompt) from Iteration 4 with a more flexible version:

public static double readNumber(String prompt, double min, double max)
This version allows setting custom validation ranges for different inputs, making the method reusable for any similar numeric prompt.

Removed the need for if-else branching inside readNumber() for each input type — now validation is based on parameters.

2. Removed Prompt-Specific Logic from the Input Method
No more string comparisons like if (prompt == "ANR") — much cleaner and less error-prone.

Transformed ANR and Period after reading, directly in calculateMortgage().

3. Added a Cleaner and Simpler main()
The variables principal, ANR, and Period are still declared initially, but your comment correctly notes that they are overridden by user input, so the initial values don’t affect the logic — good awareness!

4. Room for Improvement
Scanner is still being created inside the readNumber() method — which might lead to unnecessary resource usage if the method is called many times. In future iterations, consider:

Creating one Scanner instance at class level or passing it as a parameter.

Code is now DRY (Don't Repeat Yourself), but still procedural.

In summary, the initial values you set in the main method for principal, ANR, and Period 
do not affect the calculation of the mortgage because they are replaced by the values input by the user during the execution of the calculateMortgage method.
*/

package MortgageCal5;

import java.text.NumberFormat;
import java.util.Scanner;
public class Mort5 {

    public static void main(String[] args) {

        int principal = 1 ;    
        double ANR = 2;
        short Period = 3;    

       
        double mortgage = calculateMortgage(principal, ANR, Period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//NumberFormat class is an abstract class and we cannot instantiatte them,
        System.out.println("Mortgage: " +mortgageFormatted);//getcurrentinstance() is a method that belongs tothis abstract class   
       
    }
public static double readNumber(String prompt, double min, double max){
    Scanner sc = new Scanner(System.in);
    double value;
    while (true){
        System.out.println(prompt+":");
        value = sc.nextDouble();
    if (value >=min && value <= max){
        System.out.println(prompt +":" +value);
        //if we declare any variable inside a loop then its scope is limited to that loop
        break;
    }
    else{
        System.out.println("Value should be between the range of " +min+ "and" +max );
    }
}
return value;
}

public static double calculateMortgage(int principal, double ANR, short Period){

        double r ;
        int n ; 
    principal = (int)readNumber("principal", 1000, 100000);
    ANR = readNumber("ANR", 1, 30);
    r = ANR/100 / 12;
    Period = (short)(readNumber("Period", 1, 30));
    n = (Period * 12);
    double Mortgage = principal * (r * Math.pow(1+r , n)) / (Math.pow(1+r,n) - 1) ;
    return Mortgage;
    
}
}
