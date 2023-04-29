import java.util.Scanner;

public class Dahme {

    public static void main(String args[]) {
        int length;

        Scanner myscanner = new Scanner(System.in);

        System.out.println("Enter the length of the rectangle:");
        int breathe;

        length = myscanner.nextInt();

        System.out.println("enter the breathe of the rectangle:");

        breathe = myscanner.nextInt();

        int areaOfrectangle = length * breathe;
        int result = areaOfrectangle;
        int perimeter = 2 * (length + breathe);
        System.out.println("\n\nPerimeter :" + perimeter);
        System.out.println("Area :" + result);
    }

}
