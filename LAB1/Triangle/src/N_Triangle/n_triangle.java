package N_Triangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class n_triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = getValidHeight("Enter the height n of the triangle: ", input);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            for (int j = i + 1; j < n; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        input.close();
    }

    public static int getValidHeight(String prompt, Scanner scanner) {
        while (true) {
            int h;
            try {
                System.out.print(prompt);
                h = scanner.nextInt();
                if (h <= 0) {
                    System.out.println("Invalid input. Height must be greater than 0 or no triangle will be printed");
                    continue;
                }
                return h;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}