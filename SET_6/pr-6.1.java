import java.util.Scanner;

public class AverageCalculator {

    // Method to calculate average
    public static double average(String[] values) throws NullPointerException, NumberFormatException {
        double sum = 0;

        for (String val : values) {
            if (val == null || val.equalsIgnoreCase("null")) {
                throw new NullPointerException("Array element is null");
            }

            double num = Double.parseDouble(val);
            sum += num;
        }

        return sum / values.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("\nEnter number of elements: ");
                int n = sc.nextInt();
                sc.nextLine(); // consume newline

                String[] values = new String[n];

                // Take inputs with validation
                for (int i = 0; i < n; i++) {
                    while (true) {
                        try {
                            System.out.print("Enter value " + (i + 1) + ": ");
                            String input = sc.nextLine();

                            if (input.equalsIgnoreCase("null")) {
                                throw new NullPointerException("Null not allowed");
                            }

                            // Try parsing to check validity
                            Double.parseDouble(input);

                            values[i] = input;
                            break; // valid input → exit loop

                        } catch (NullPointerException e) {
                            System.out.println("Invalid! Null value not allowed. Try again.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid! Enter a valid number.");
                        }
                    }
                }

                // Calculate average
                double result = average(values);
                System.out.println("Average = " + result);

            } catch (Exception e) {
                System.out.println("Error: " + e);
                sc.nextLine(); // clear buffer
            }

            // Ask user to continue
            System.out.print("Do you want to continue? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Program ended.");
        sc.close();
    }
}