package LAB1;

import java.util.Scanner;

public class ex226 {
    public static void FirstDegreeEquation() {
        Scanner input = new Scanner(System.in);
        double a = Utility.getValidDouble("Enter coefficient of x: ", input);
        double b = Utility.getValidDouble("Enter the constant: ", input);
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solutions");
            } else {
                System.out.println("The equation has no solution");
            }
        } else {
            double x = -b / a;
            System.out.println("Solution of the equation: x = " + x);
        }
    }

    public static void LinearSystem() {
        Scanner input = new Scanner(System.in);
        double a11 = Utility.getValidDouble("Enter a11: ", input);
        double a12 = Utility.getValidDouble("Enter a12: ", input);
        double b1 = Utility.getValidDouble("Enter b1: ", input);
        double a21 = Utility.getValidDouble("Enter a21: ", input);
        double a22 = Utility.getValidDouble("Enter a22: ", input);
        double b2 = Utility.getValidDouble("Enter b2: ", input);
        double D = a11 * a22 - a12 * a21;
        double Dx = b1 * a22 - b2 * a12;
        double Dy = a11 * b2 - a21 * b1;
        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                System.out.println("The system has infinite solutions");
            } else {
                System.out.println("The system has no solution");
            }
        } else {
            System.out.println("Solution of the system:");
            double x1 = Dx / D;
            double x2 = Dy / D;
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        }
    }

    public static void SecondDegreeEquation() {
        Scanner input = new Scanner(System.in);
        double a = Utility.getValidDouble("Enter the coefficient of x^2: ", input);
        double b = Utility.getValidDouble("Enter the coefficient of x: ", input);
        double c = Utility.getValidDouble("Enter the constant: ", input);
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The equation has infinite solutions");
                } else {
                    System.out.println("The equation has no solution");
                }
            } else {
                double x = -c / b;
                System.out.println("The equation has single root: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("The equation has no real root");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has double root: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The equation has 2 real roots:");
                System.out.println("x1: " + x1);
                System.out.println("x2: " + x2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. The first-degree equation (linear equation) with one variable");
        System.out.println("2. The system of first-degree equations (linear system) with two variables");
        System.out.println("3. The second-degree equation with one variable");
        System.out.println("-1. Exit");
        int choice;
        do {
            choice = Utility.getValidInt("What's your choice?: ", input);
            switch (choice) {
                case 1:
                    FirstDegreeEquation();
                    break;
                case 2:
                    LinearSystem();
                    break;
                case 3:
                    SecondDegreeEquation();
                    break;
                case -1:
                    System.out.println("Goodbye!!!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != -1);
        input.close();
    }
}