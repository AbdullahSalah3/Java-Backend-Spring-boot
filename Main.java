import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create this object to read user inputs

        // Initial setup variables
        final int correctPIN = 1234; // why final ? because this value can not edit it
        int maxAttempts = 3;
        int attemptsUsed = 0;
        boolean loggedIn = false;

        // ATM State variables
        double balance = 2500.75;
        int transactionCount = 0;

        do {  // i used it to verify PIN  before check condition
            System.out.print("Enter your 4-digit PIN: ");
            int enteredPin = scanner.nextInt(); // that mean wait for the user to type a number and save it in 'enteredPin'
            attemptsUsed++;

            if (enteredPin == correctPIN) { // Check if the typed PIN equal the correct PIN (1234)
                loggedIn = true;
                System.out.println("Login successful!\n");
            } else {
                int remaining = maxAttempts - attemptsUsed; // to calculate how many attempts are left by subtracting
                if (remaining > 0) {
                    System.out.println("Incorrect PIN. You have " + remaining + " attempts left.");
                } else {
                    System.out.println("Your account has been locked.");
                    return;
                }
            }
        } while (!loggedIn && attemptsUsed < maxAttempts);

        // Keeps the ATM menu running repeatedly after successful login
        while (loggedIn) {
            System.out.println("/////////////////////////");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("////////////////////////");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // take integer from user

            // Jump to the case based on the chosen option
            switch (choice) {
                case 1:
                    // Check Balance
                    System.out.println("Your current balance is: $" + balance);
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();


                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount.\n");
                    } else {
                        balance += depositAmount; // Add the deposit amount directly to their balance
                        transactionCount++;
                        // Bonus Challenge: Display updated balance
                        System.out.println("Successfully deposited $" + depositAmount + " New Balance: $" +  balance);
                    }
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();


                    if (withdrawAmount == 0) {
                        System.out.println("Transaction cancelled.\n");
                        // Check if  negative number
                    } else if (withdrawAmount < 0) {
                        System.out.println("Invalid amount.\n");
                        // Check if they are trying to take out more money than they actually have
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.\n");
                    } else {
                        balance -= withdrawAmount;
                        transactionCount++;

                        System.out.printf("Successfully withdraw $" + withdrawAmount + " New Balance: $" +  balance);

                        // Check if their account balance dropped to exactly 0.0
                        if (balance == 0.0) {
                            System.out.println("Warning: Your account is empty.");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    // Show Account Status
                    // Check if their balance is 5000 or more
                    if (balance >= 5000) {
                        System.out.println("Account Status: VIP Customer\n");
                        // Check if their balance is between 1000 and 4999.99
                    } else if (balance >= 1000 && balance < 5000) {
                        System.out.println("Account Status: Regular Customer\n");
                    } else {
                        System.out.println("Account Status: Low Balance\n");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Thank you for using our ATM.");
                    // Bonus Challenge: Display total successful transactions
                    System.out.println("Total successful transactions completed: " + transactionCount);

                    // Set loggedIn to false so the main loop knows it's time to stop
                    loggedIn = false;
                    break;

                default:
                    // Invalid choice fallback
                    System.out.println("Invalid option.\n");
                    break;
            }

            // Checking if the break statement was triggered to terminate the while loop
            if (!loggedIn) {
                break;
            }
        }

        scanner.close(); // Close the scanner to keep the computer's memory clean
    }
}