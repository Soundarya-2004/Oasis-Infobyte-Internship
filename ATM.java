
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int pin = 1234; // Default PIN
        double balance = 1000.00; // Default balance
        int attempts = 3; // Number of attempts for PIN entry

        System.out.println("Welcome to the ATM!");

        while (attempts > 0) {
            System.out.print("Please enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == pin) {
                System.out.println("PIN accepted. You can now access your account.");
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. You have " + attempts + " attempts left.");
            }
        }

        if (attempts == 0) {
            System.out.println("Too many incorrect attempts. Your account is locked.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: $%.2f\n", balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.printf("$%.2f deposited successfully.\n", depositAmount);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.printf("$%.2f withdrawn successfully.\n", withdrawAmount);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        System.out.println("Invalid withdrawal amount.");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM");
                    System.out.println("Have a great day!!!");

                    break;
                default:
                    System.out.println("Invalid option. Please try again.");

    
}
        }
    }
}

