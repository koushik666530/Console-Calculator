import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCalculator {

    // Arithmetic operations
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    private static void showMenu() {
        System.out.println("\n=== Java Console Calculator ===");
        System.out.println("1) Addition (+)");
        System.out.println("2) Subtraction (-)");
        System.out.println("3) Multiplication (*)");
        System.out.println("4) Division (/)");
        System.out.println("5) Exit");
        System.out.print("Choose an option (1-5): ");
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                scanner.nextLine(); // clear bad input
                continue;
            }

            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Option out of range. Try again.");
                continue;
            }

            double x, y;
            try {
                System.out.print("Enter first number: ");
                x = scanner.nextDouble();
                System.out.print("Enter second number: ");
                y = scanner.nextDouble();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid number. Please enter numeric values.");
                scanner.nextLine(); // clear bad input
                continue;
            }

            double result;
            switch (choice) {
                case 1 -> {
                    result = add(x, y);
                    System.out.printf("Result: %.6f + %.6f = %.6f%n", x, y, result);
                }
                case 2 -> {
                    result = subtract(x, y);
                    System.out.printf("Result: %.6f - %.6f = %.6f%n", x, y, result);
                }
                case 3 -> {
                    result = multiply(x, y);
                    System.out.printf("Result: %.6f * %.6f = %.6f%n", x, y, result);
                }
                case 4 -> {
                    if (y == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        result = divide(x, y);
                        System.out.printf("Result: %.6f / %.6f = %.6f%n", x, y, result);
                    }
                }
                default -> // unreachable
                    System.out.println("Unexpected error.");
            }

            // Ask whether to continue
            scanner.nextLine(); // consume newline
            System.out.print("Perform another calculation? (y/n): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!(again.equals("y") || again.equals("yes"))) {
                running = false;
                System.out.println("Exiting calculator. Goodbye!");
            }
        }

        scanner.close();
    }
}
// java ConsoleCalculator
