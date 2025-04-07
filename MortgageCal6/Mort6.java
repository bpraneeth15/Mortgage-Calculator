//In this 6th iteration we just include a method to calculate payment schedule.


package MortgageCal6;
import java.text.NumberFormat;
import java.util.Scanner;

public class Mort6 {

final static byte PERCENT = 100;
final static byte MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {

        int principal = 1 ;    
        double ANR = 2;
        short Period = 3;    

       
        double mortgage = calculateMortgage(principal, ANR, Period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//NumberFormat class is an abstract class and we cannot instantiatte them,
        System.out.println("Monthly Payments: " + mortgageFormatted);
        System.out.println();
        
    }
public static double readNumber(String prompt, double min, double max){
    Scanner sc = new Scanner(System.in);
    double value;
    while (true){
        System.out.println(prompt+":");
        value = sc.nextDouble();
    if (value >=min && value <= max){
        System.out.println(prompt +":" +value);
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
    principal = (int)readNumber("principal", 1000, 1000000);
    ANR = readNumber("ANR", 1, 30);
    r = ANR/PERCENT / MONTHS_IN_YEAR;
    Period = (short)(readNumber("Period", 1, 30));
    n = (Period * 12);
    double Mortgage = principal * (r * Math.pow(1+r , n)) / (Math.pow(1+r,n) - 1) ;
    remainingBalance(principal, r, n);
    return Mortgage;
    
}

//the payment schedule gives us how many montlhy payments are to be made and also gives the amount for each and every monthly payment. 
// this means the remaining balace will keep on  displaying until the number becomes zero. so for this we can add a for loop with a conditional statement telling to stop the loop once the ampunt/remaining balance reaches zero. 
// we just have to calculate remaining balance and display it. this is the core function of the paymentSchedule method.
public static void remainingBalance(int Principal, double r, int n){
    System.out.println("PAYMENT SCHEDULE:");
    // since p is no of payments the we have made till then, we can calculate its value by using the for loop,
    for(int p = 0; p <= n; p++){
    double remainingBalance = Principal* (Math.pow(1+r , n) - Math.pow(1+r, p)) / (Math.pow(1+r , n) - 1);
    String balance = NumberFormat.getCurrencyInstance().format(remainingBalance);
    System.out.println(balance);
    }

}
}

 /*this is procedural programming in action. Next we are going to add the abstraction, encapsulation and other object oriented features 
 to this code. Look in 'MortgageCalRefactor' file there are 4 files  */