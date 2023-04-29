import java.util.Scanner;

public class RectangleCalculator {

    private float length, breadth;

    public void getLengthAndBreadth() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("$ Enter the length: ");

        this.length = scanner.nextFloat();

        System.out.println("$ Enter the breadth: ");

        this.breadth = scanner.nextFloat();

        scanner.close();

    }

    public float findArea() {

        return (this.length * this.breadth);
    }

    public float findPerimeter() {

        return 2 * (this.length + this.breadth);
    }

    public static void main(String args[]) {

        RectangleCalculator rectangleCalculator = new RectangleCalculator();

        rectangleCalculator.getLengthAndBreadth();

        float area = rectangleCalculator.findArea();

        float perimeter = rectangleCalculator.findPerimeter();

        System.out.printf("\n Area: %.4f \n", area);

        System.out.printf("Perimeter: %.4f \n", perimeter);

    }

}
