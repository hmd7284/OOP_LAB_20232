package LAB1;

import java.util.Scanner;

public class ex225 {
    public static void main(String[] args) {
        double num1;
        double num2;
        Scanner input = new Scanner(System.in);
        num1 = Utility.getValidDouble("Enter num1: ", input);
        num2 = Utility.getValidDouble("Enter num2: ", input);
        double sum = num1 + num2;
        double diff = num1 - num2;
        double product = num1 * num2;
        System.out.println("Sum: " + sum);
        System.out.println("Diff: " + diff);
        System.out.println("Product: " + product);
        if (num2 == 0) {
            System.out.println("Can't find quotient, divisor is 0");
        } else {
            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        }

        input.close();
    }

}