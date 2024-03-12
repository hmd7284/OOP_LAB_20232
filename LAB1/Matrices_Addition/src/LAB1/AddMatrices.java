package LAB1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = getValidSize("Enter rows: ", input);
        int cols = getValidSize("Enter cols: ", input);
        int[][] mat1 = new int[rows][cols];
        int[][] mat2 = new int[rows][cols];
        System.out.println("Enter elements of 1st matrix: ");
        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                mat1[i][j] = getValidElement(input);
            }
        }
        System.out.println("Enter elements of 2nd matrix: ");
        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                mat2[i][j] = getValidElement(input);
            }
        }
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            System.out.println(" 2 matrices with different size");
            return;
        }
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        System.out.println("The sum matrix is:");
        for (int[] row : sum) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        input.close();

    }

    public static int getValidSize(String prompt, Scanner scanner) {
        while (true) {
            int num;
            try {
                System.out.print(prompt);
                num = scanner.nextInt();
                if (num < 1) {
                    System.out.println("Invalid input. Row and cols must be >= 1");
                    continue;
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    public static int getValidElement(Scanner scanner) {
        while (true) {
            int num;
            try {
                num = scanner.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid integers.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

}