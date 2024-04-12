package com.pluralsight;
import java.util.Scanner;

public class FinancialCalculators {

    // main method
    public static void main(String[] args) {
        getUserInput();
    }

    // user input method
    public static void getUserInput () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi :) Please pick one of the following calculators!");
        System.out.println("Select 1 for Mortgage, 2 for Future Value, or 3 for Present Value.");
        System.out.print("Enter here : ");
        int userChoice = scanner.nextInt();
        //clearing CRLF from the last scanner left in input buffer after int
        // scanner.nextLine();
        // switch cases for user input and error handling in case valid input is not given
        switch (userChoice) {
            case 1 : getMortgageValues(scanner);
            break;
            case 2 : futureValue(scanner);
            break;
            case 3 : presentValueCalculator(scanner);
            break;
            default : System.out.println(" !!! Input invalid please select a number from 1-3. !!!");
                      getUserInput();
            break;
        }
    }

    // get user values for the mortgage calculator
    public static void getMortgageValues (Scanner scanner) {
        System.out.println("You have selected the mortgage calculator.");
        System.out.print("Please provide the principle amount : ");
        double principle = scanner.nextDouble();
        System.out.print("Please provide the interest amount : ");
        double interest = scanner.nextDouble();
        System.out.print("Please provide the years: ");
        double years = scanner.nextDouble();
        mortgageCalculator(principle, interest, years);
    }

    // mortgage calculator method
    public static void mortgageCalculator (double principle, double years, double interest) {

        double monthlyInterestRate = interest / 1200;
        double payments = years * 12;
        double monthlyMortgagePayment =
                principle * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, payments))
                        / (Math.pow(monthlyInterestRate + 1, payments) - 1);

        System.out.printf("Your monthly payment will be $%.2f \n", monthlyMortgagePayment);

        double totalLoan = payments * monthlyMortgagePayment;
        double totalInterest = totalLoan - principle;

        System.out.printf("This loan will cost you $%.2f \n", totalLoan);
        System.out.printf("The total interest is $%.2f", totalInterest);
    }


    // future value calculator
    public static void futureValue (Scanner scanner) {
        System.out.println("You have selected the future value calculator");
    }

    // present value calculator
    public static void presentValueCalculator (Scanner scanner) {
        System.out.println("You have selected the present value calculator");
    }

}
