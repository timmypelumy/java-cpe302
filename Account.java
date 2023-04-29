import java.util.Date;
import java.util.Scanner;

public class Account {

    private float balance;
    private long created;
    private String name;
    private static double INTEREST_RATE = 0.0005;

    public Account(Scanner scanner) {

        this.created = new Date().getTime();
        this.balance = 0;

        System.out.print("\nWelcome to Bank of Black and White, What's your name? :  ");
        name = scanner.next();

    }

    public void showBalance() {

        System.out.printf("\n Your balance is: %.2f #", this.balance);

    }

    public void withdraw(Scanner scanner) {

        System.out.print("\n Enter an amount to withdraw: ");

        float amount = scanner.nextFloat();

        if (amount <= 0) {

            System.out.println(
                    "\n Amount to withdraw must be greater than 0 #");

            return;

        }

        if (amount > this.balance) {

            System.out.printf(
                    "\n You do not have sufficient balance, please make a deposit first. Your current balance is %.2f # \n",
                    this.balance);

        }

        else {

            this.balance -= amount;

            System.out.printf("\n Withdrawal of %.2f # was successful, your new balance is %.2f #\n", amount,
                    this.balance);

        }

    }

    public void deposit(Scanner scanner) {

        System.out.print("\n Enter an amount to deposit: ");

        float amount = scanner.nextFloat();

        if (amount <= 0) {

            System.out.println(
                    "\n Amount to deposit must be greater than 0 #");

        }

        else {

            this.balance += amount;

            System.out.printf("\n Deposit of %.2f # was successful, your new balance is %.2f #\n", amount,
                    this.balance);

        }
    }

    public void computeInterest() {

        float diffInSecs = (new Date().getTime() - this.created) / 1000;

        double interest = this.balance * INTEREST_RATE * diffInSecs;

        System.out.printf(
                "\nYour account is %.2f seconds old, hence, Interest is: %.2f # at %f percent per second. \n",
                diffInSecs,
                interest,
                INTEREST_RATE);

    }

    // Main Function

    public static void main(String args[]) {

        Scanner loopscanner = new Scanner(System.in);
        Account account = new Account(loopscanner);

        int prompt = 1;

        while (prompt != 0) {

            System.out
                    .print(
                            "\n\nDear " + account.name
                                    + ", choose an operation: \n1 to show balance\n2 to deposit\n3 to withdraw\n4 to compute interest\n0 to exit\n\n$  ");

            prompt = loopscanner.nextInt();
            switch (prompt) {

                case 1:
                    account.showBalance();
                    break;
                case 2:
                    account.deposit(loopscanner);
                    break;

                case 3:
                    account.withdraw(loopscanner);
                    break;
                case 4:
                    account.computeInterest();
                case 0:
                    break;

                default:
                    System.out.println("\nYour selection is invalid, try again.");

            }

        }

        loopscanner.close();

        System.out.println("\n Thank you for banking with us " + account.name + "!");

    }

}
