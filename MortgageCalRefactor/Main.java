package MortgageCalRefactor;

public class Main {
  
    public static void main(String[] args) {
        // creating a console object inorder to access this readNumber method.
        var console = new Console();
      
        //i just created a console class  object here and then used it to initialize the principal, annualInterest, years.
            int principal = (int) console.readNumber("Principal: ", 1000, 1_000_000);
            float annualInterest = (float) console.readNumber("Annual Interest Rate: ", 1, 30);
            byte years = (byte) console.readNumber("Period (Years): ", 1, 30);
             // Creating a MortgageCalculation instance with the user input
            MortgageCalculation mort1 = new MortgageCalculation(principal, annualInterest, years);
    
            // Passing the MortgageCalculation instance to the MortgageReport constructor
            var report = new MortgageReport(mort1); 
            report.printMortgage();
            report.printPaymentSchedule();
        // report.printMortgage(principal, annualInterest, years);
        // report.printPaymentSchedule(principal, annualInterest, years);
    }

     
}
