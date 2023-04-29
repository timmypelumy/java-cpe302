import java.util.Scanner;

public class Grading {

    public static int courseUnits[] = new int[10];

    public static String courseGrades[] = new String[10];

    public static String courseCodes[] = new String[10];

    public static int numberOfCourses;

    public static void getData() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of courses you offer (whole numbers only): ");

        numberOfCourses = scanner.nextInt();

        if (numberOfCourses > 10) {
            System.out.print("\n -Number of courses must be less than or equal to 10\n");
            scanner.close();
            return;

        }

        for (int i = 0; i < numberOfCourses; ++i) {

            System.out.print("\n -Enter the course code for course " + (i + 1) + " : ");
            String c = scanner.next();

            System.out.print(" -Enter the units for course " + (i + 1) + " (whole numbers only): ");
            int u = scanner.nextInt();

            System.out.print(" -Enter your grade for course " + (i + 1) + " (A,B,D,E or F): ");
            String g = scanner.next();

            courseUnits[i] = u;
            courseGrades[i] = g.toUpperCase().strip();
            courseCodes[i] = c.toUpperCase();

        }

        scanner.close();

    }

    public static void printData() {

        System.out.print("\n");
        for (int i = 0; i < numberOfCourses; ++i) {
            System.out.print("\n  " + courseCodes[i] + " " + courseUnits[i] + " units  Grade: " + courseGrades[i]);

        }
        System.out.print("\n\n");

    }

    public static int getGradePoints(String gradeLetter) {

        if (gradeLetter.equals("A"))
            return 5;

        if (gradeLetter.equals("B"))
            return 4;

        if (gradeLetter.equals("C"))
            return 3;

        if (gradeLetter.equals("D"))
            return 2;

        return 0;

    }

    public static void main(String[] args) {

        // Intro

        System.out.println("\n- Welcome to Grade Calculator\n");

        getData();

        System.out.print("\n- Courses' Data");
        printData();

        // Compute the total load points and total load units
        float tlu, tlp;
        tlu = tlp = 0;

        for (int i = 0; i < numberOfCourses; ++i) {

            tlu += courseUnits[i];
            tlp += (getGradePoints(courseGrades[i]) * courseUnits[i]);

        }

        float gpa = (tlp / tlu);

        System.out.println("\n~ Total Load Points: " + tlp);
        System.out.println("~ Total Load Units: " + tlu);
        System.out.printf("~ Grade Point Area: %,.2f \n", gpa);

    }

}
