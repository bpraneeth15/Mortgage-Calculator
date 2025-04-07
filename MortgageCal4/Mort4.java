/*in this 4th iteration we are going to extract the repetetive lines of code and create a new method.
for example we have while loops repeatedly and if we observe they follow same pattern asking the question to enter a value and then validating,
 we will create a one method for reading and validating the inputs
 
 Extracted all repetitive input+validation code into one method readNumber(), making the code modular and cleaner. 
 Introduced abstraction but still procedural; sets up the foundation for the next step: 
 Object-Oriented Design.
 */

package MortgageCal4;


import java.text.NumberFormat;
import java.util.Scanner;
public class Mort4 {
 

    public static void main(String[] args) {

        int principal = 0 ;    
        double ANR = 0;
        int Period = 0;    

       
        double mortgage = calculateMortgage(principal, ANR, Period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//NumberFormat class is an abstract class and we cannot instantiatte them,
        System.out.println("Mortgage: " +mortgageFormatted);//getcurrentinstance() is a method that belongs tothis abstract class   
       
    }


// prompt parameter is already there so that we can call this method using  the method call step in the calculate mortgage mmethod.
public static double readNumber(String prompt){
    Scanner sc = new Scanner(System.in);
    double value;
    while (true){
        System.out.println(prompt+ ":");

        value = sc.nextDouble();
       if (prompt == "principal" && value >=1000 && value <= 100000){
        System.out.println("PRINCIPAL: " +value); 
        //if we declare any variable inside a loop then its scope is limited to that loop
        continue;
       }

        else if(prompt == "ANR" && value >=1 && value <= 30){
            System.out.println(prompt + ":");
            value = value/100 /12;
            System.out.println("monthlyInterestRate: " +value);
            break;

        }
        else if(prompt == "Period" && value >= 1 && value <= 30){
            System.out.println(prompt + ":");
            value = value * 12;
            break;
        }
      

        else{
            System.out.println("enter a value between ");
        }
    }
    return value;
}



public static double calculateMortgage(int principal, double ANR, int Period){

         //we just declared it outside the loop to give its access to the calulating formula and at the same time the v alue given will be checked for validation
         //we have declared ANR at the top outside of the loop so that its scope is thropugh out the program.
        
    principal = (int)readNumber("principal");
    float r = (float)readNumber("ANR");
    short n = (short)readNumber("Period");
    double Mortgage = principal * (r * Math.pow(1+r , n)) / (Math.pow(1+r,n) - 1) ;
    return Mortgage;
}
}
// we can see that there are repettitive patterns of while loop and if statements in this code. we are going to refactor this code using the oop methods and simplfy the codein the next iteration

