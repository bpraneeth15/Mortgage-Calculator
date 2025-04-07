//In this 3rd iteration we are going to extract the methods and create a new nethod for calculating the mortgage

package MortgageCal3;
import java.text.NumberFormat;
import java.util.Scanner;
public class MortCal3 {

    public static void main(String[] args) {

        int principal = 0 ;    
        double ANR = 0;
        int Period = 0;    

       
        double mortgage = calculateMortgage(principal, ANR, Period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//NumberFormat class is an abstract class and we cannot instantiatte them,
        System.out.println("Mortgage: " +mortgageFormatted);//getcurrentinstance() is a method that belongs tothis abstract class   
       
    }


public static double calculateMortgage(int principal, double ANR, int Period){

    Scanner sc = new Scanner(System.in);
         //we just declared it outside the loop to give its access to the calulating formula and at the same time the v alue given will be checked for validation
        double r ; //we have declared ANR at the top outside of the loop so that its scope is thropugh out the program.
        short n ; 
    while (true){
        System.out.println("PRINCIPAL: ");

        principal = sc.nextInt();
    if (principal >=1000 && principal <= 100000){
        System.out.println("PRINCIPAL: ");
        //if we declare any variable inside a loop then its scope is limited to that loop
        break;
    }
    else{
        System.out.println("principal amount should be between 1000 and 100000 ");
    }
}

    while(true){
        System.out.println("Enter the annual interest rate:");

         ANR = sc.nextFloat();
    //for giving to the formula we are converting anr to monthly Interest rate 
    if (ANR >=1 && ANR <= 30){
        System.out.println("ANR: " +ANR);

        r = ANR/100 /12;
        System.out.println("monthlyInterestRate: " +r);
    break;
    }
    else{
        System.out.println("Annual interest rate should be between 1 to 30: ");
    }
}
    
    while(true){
        System.out.println("Period: ");

        Period = sc.nextByte();
        if (Period >= 1 && Period <= 30){
             n = (short)(Period * 12);//n is int period is byte, n will have greater values because it represent months and byte is sufficient for Period because it has lower values. 
             System.out.println("No of monthly payments: " +n);
             break;
        }
        else{
            System.out.println("period cannot be less than 1 and greater than 30");
        }
    }
    double Mortgage = principal * (r * Math.pow(1+r , n)) / (Math.pow(1+r,n) - 1) ;
    return Mortgage;
}


}
// we can see that there are repettitive patterns of while loop and if statements in this code. we are going to refactor this code using the oop methods and simplfy the codein the next iteration