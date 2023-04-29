import java.util.Scanner;

public class Rectangle {

    private float length, breadth;

    public void getParameters() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n \t\t Rectangle Calculator");

        System.out.print("-> Enter the length of the rectangle: ");

        this.length = scanner.nextFloat();

        System.out.print("-> Enter the breadth of the rectangle: ");

        this.breadth = scanner.nextFloat();

        scanner.close();

    }

    public float computePerimeter() {

        return 2 * (this.length + this.breadth);
    }

    public float computeArea() {

        return (this.length * this.breadth);
    }

    public static void main(String args[]) {

        Rectangle rectangle = new Rectangle();

        rectangle.getParameters();

        float area = rectangle.computeArea();

        float perimeter = rectangle.computePerimeter();

        System.out.printf("\nThe area of the rectangle is: %.2f \n", area);

        System.out.printf("The perimeter of the rectangle is: %.2f \n", perimeter);

    }

}
