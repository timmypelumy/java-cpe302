import java.util.Scanner;

public class CI {

    public static void main(String args[]) {

        float principal, rate, time;

        System.out.println("\n  Compound Interest Calculator \n");

        System.out.println("$ Enter the principal: ");

        Scanner scanner = new Scanner(System.in);

        principal = scanner.nextFloat();

        System.out.println("$ Enter the rate: ");

        rate = scanner.nextFloat();

        System.out.println("$ Enter the time: ");

        time = scanner.nextFloat();

        scanner.close();

        float amount = principal * (float) Math.pow((1 + (rate / 100)), time);

        float compoundInterest = amount - principal;

        System.out.printf("\n Amount: %.4f \n", amount);

        System.out.printf("Compound Interest: %.4f \n", compoundInterest);

    }

}