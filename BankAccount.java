import java.util.Date;
import java.util.Scanner;

public class BankAccount {

    private float balance;
    private long created;
    private String bankAccountNumber;

    public void setup() {

        this.balance = 0;
        this.created = new Date().getTime();

        String temp = "";

        for (int i = 0; i <= 10; ++i) {

            String r = "" + (int) (Math.random() * 10);

            temp = temp.concat(r);

        }

        this.bankAccountNumber = temp;

        System.out.println("\nWelcome to your BankAccount\n");
        System.out.println("\t BankAccount Number: " + this.bankAccountNumber);

    }

    public void showBalance() {

        System.out.printf("\n\t Your balance is: %.2f #", this.balance);

    }

    public void withdrawAmount(float amount) {

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

    public void depositAmount(float amount) {

        if (amount <= 0) {

            System.out.println(
                    "\n Amount to deposit must be greater than 0 #");
            return;

        }

        this.balance += amount;

        System.out.printf("\n Deposit of %.2f # was successful, your new balance is %.2f #\n", amount,
                this.balance);

    }

    public void computeInterest() {

        long now = new Date().getTime();

        long elpased = now - this.created;

        int secs = (int) elpased / 1000;

        System.out.printf(
                "\n\n\tInterest is: %.2f # in %d seconds at 0.0001 percent per second. \n",

                (this.balance * 0.0001) * secs, secs);

    }

    // Main Function

    public static void main(String args[]) {

        BankAccount BankAccount = new BankAccount();
        BankAccount.setup();

        System.out.println("\n $ Enter an amount to deposit: ");

        Scanner scanner = new Scanner(System.in);

        float amount = scanner.nextFloat();

        BankAccount.depositAmount(amount);

        System.out.println("\n $ Enter an amount to withdraw: ");

        amount = scanner.nextFloat();

        BankAccount.withdrawAmount(amount);

        BankAccount.showBalance();

        BankAccount.computeInterest();

        scanner.close();

    }

}
