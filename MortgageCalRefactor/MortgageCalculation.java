package MortgageCalRefactor;

import java.text.NumberFormat;

public class MortgageCalculation {

    public final  byte MONTHS_IN_YEAR = 12;
    public final  byte PERCENT = 100;
            int principal;
            float annualInterest;
            byte years;
            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            float numberOfPayments = years * MONTHS_IN_YEAR;

    public MortgageCalculation(int principal, float annualInterest, byte years) {
                this.principal = principal;
                this.annualInterest = annualInterest;
                this.years = years;
    }
     
    // public MortgageCalculation() {
    // TODO Auto-generated constructor stub

    public void getBalance() {
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balanceRemaining = calculateBalance();
            System.out.println(NumberFormat.getCurrencyInstance().format(balanceRemaining));
        }
    }

    public  double calculateBalance() 
    {
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    
        return balance;
    }


    public  double calculateMortgage() {
    
        // float monthlyInterest = annualInterest / PERCENT /MONTHS_IN_YEAR;
        // float numberOfPayments = years * MONTHS_IN_YEAR;
    
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    
        return mortgage;
    }
    
}
