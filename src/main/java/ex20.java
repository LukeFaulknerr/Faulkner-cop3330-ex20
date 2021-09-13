/*
    UCF COP3330 Fall 2021 Assignment 20 Solution
    Copyright 2021 Luke Faulkner
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ex20 {
    public static void main(String[] args) {
        // Variables
        int orderAmt;
        double tax = 0, cost;
        String orderAmtStr, state, county;
        Scanner taxReader = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        // Prompt
        System.out.print("What is the order amount? ");
        orderAmtStr = taxReader.nextLine();
        orderAmt = Integer.parseInt(orderAmtStr);

        System.out.print("What state do you live in? ");
        state = taxReader.nextLine();

        // Tax Calc
        if (state.equals("Wisconsin") || state.equals("WI")){
            tax = orderAmt * 0.05;
            System.out.print("What county do you live in? ");
            county = taxReader.nextLine();
            if (county.equals("Eau Claire"))
                tax = tax + orderAmt * 0.005;
            else if (county.equals("Dunn"))
                tax = tax + orderAmt * 0.004;
        }
        else if (state.equals("Illinois") || state.equals("IL"))
            tax = orderAmt * 0.08;

        // Final cost
        cost = orderAmt + tax;

        // Result
        System.out.println("The tax is $" + df.format(tax));
        System.out.print("The total is $" + df.format(cost));

    }
}
