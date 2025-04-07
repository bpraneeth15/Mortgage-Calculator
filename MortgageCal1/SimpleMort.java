import java.text.NumberFormat;
import java.util.Scanner;

public class SimpleMort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the principal amount:");
        Long principal = sc.nextLong();
        System.out.println("Enter the annual interest rate:");
        Double ANR = sc.nextDouble();
        //for giving to the formula converting anr to monthly Interest rate 
        Double r = ANR/100 /12;

        System.out.println("Enter the loan term in years:");
        int Period = sc.nextByte();
        int n = Period * 12;

        double CalculateMortgage = principal * (r * Math.pow(1+r , n)) / (Math.pow(1+r,n) - 1) ;
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(CalculateMortgage);
        System.out.println("Mortgage: " +mortgageFormatted);
        sc.close();
        
    }
}
