package LAB1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Num_Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = getValidSize("Enter the size of array: ", input);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String prompt = "Enter element " + (i + 1) + " of the array: ";
            arr[i] = getValidElement(prompt, input);
        }
        Arrays.sort(arr);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double avg = sum / n;
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum of all elements: " + sum);
        System.out.println("Average value: " + avg);
        input.close();
    }

    public static int getValidElement(String prompt, Scanner scanner) {
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

    public static int getValidSize(String prompt, Scanner scanner) {
        while (true) {
            int num;
            try {
                System.out.print(prompt);
                num = scanner.nextInt();
                if (num <= 0) {
                    System.out.println("Invalid input. Array size must be greater than 0");
                    continue;
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}