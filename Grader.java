public class Grader {

    public static int[][] courseScoreAndCourseUnits = { { 53, 3 }, { 68, 3 }, { 99, 2 }, { 72, 3 }, { 65, 1 },
            { 69, 3 },
            { 54, 2 }, { 59, 3 }, { 97, 3 }, { 67, 1 } };

    public static char evaluateScore(int grade) {

        if (grade >= 0 && grade < 45)
            return 'D';

        if (grade >= 45 && grade < 59)
            return 'C';

        if (grade >= 60 && grade < 69)
            return 'B';

        if (grade >= 69 && grade <= 100)
            return 'A';

        return 'F';

    }

    public static int convertGradeToPoints(char grade) {

        if (grade == 'A')
            return 5;

        if (grade == 'B')
            return 4;

        if (grade == 'C')
            return 3;

        if (grade == 'D')
            return 2;

        return 0;

    }

    public static void main(String[] args) {

        System.out.println("\n- Grader \n");
        System.out.println("- Your  score and units are: ");

        int i = 0;
        for (int[] item : courseScoreAndCourseUnits) {
            ++i;

            System.out.println("Course " + i);
            System.out.print("\tunits: " + item[1]);
            System.out.println("\tscore: " + item[0] + "\n");

        }

        float TOTAL_LOAD_UNITS, TOTAL_LOAD_POINTS;
        TOTAL_LOAD_UNITS = TOTAL_LOAD_POINTS = 0;

        for (int[] item : courseScoreAndCourseUnits) {

            TOTAL_LOAD_UNITS += (item[1]);
            TOTAL_LOAD_POINTS += (convertGradeToPoints(evaluateScore(item[0])) * item[1]);

        }

        System.out.println("- TOTAL_LOAD_POINTS: " + TOTAL_LOAD_POINTS);
        System.out.println("- TOTAL_LOAD_UNITS: " + TOTAL_LOAD_UNITS);

        float GPA = TOTAL_LOAD_POINTS / TOTAL_LOAD_UNITS;

        System.out.println("- GRADE_POINT_AVERAGE: " + GPA);

    }

}
