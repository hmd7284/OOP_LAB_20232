package LAB1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    public static double getValidDouble(String prompt, Scanner scanner) {
        while (true) {
            double num;
            try {
                System.out.print(prompt);
                num = scanner.nextDouble();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
    public static int getValidInt(String prompt, Scanner scanner) {
        while (true) {
            int num;
            try {
                System.out.print(prompt);
                num = scanner.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}