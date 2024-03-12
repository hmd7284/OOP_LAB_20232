package LAB1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Days_In_Month {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = getValidMonth("Enter month (Full name: e.g. \"January\"; Abbreviation: e.g. \"Jan.\"; 3 letters: e.g. \"Jan\"; Number: e.g. 1): ", input);
        int year = getValidYear("Enter year (Must be non-negative integer; e.g. 2024): ", input);
        int day = getDate(month, year);
        System.out.println("Number of days in given month: " + day);
        input.close();
    }

    public static int getValidMonth(String prompt, Scanner scanner) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthNames3 = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] monthNamesAbb = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        while (true) {
            try {
                System.out.print(prompt);
                int monthNum = scanner.nextInt();
                if (monthNum > 12 || monthNum < 1) {
                    System.out.println("Invalid input. Month must be between 1 and 12");
                    continue;
                }
                return monthNum;
            } catch (InputMismatchException e) {
                String monthName = scanner.nextLine().replace(".", "");
                for (int i = 0; i < monthNames.length; i++) {
                    if (monthName.equals(monthNames[i]) || monthName.equals(monthNamesAbb[i]) || monthName.equals(monthNames3[i])) {
                        return i + 1;
                    }
                }
                System.out.println("Invalid month input!! Please enter month in the correct form");
            }
        }
    }

    public static int getValidYear(String prompt, Scanner scanner) {
        while (true) {
            int year;
            try {
                System.out.print(prompt);
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Invalid input. Year must be non-negative");
                    continue;
                }
                return year;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDate(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day;
        if (month == 2 && isLeapYear(year)) day = 29;
        else {
            day = days[month - 1];
        }
        return day;
    }
}