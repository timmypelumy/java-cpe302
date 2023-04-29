import java.util.Scanner;
import java.util.WeakHashMap;

// Student Class

class Student {

    String firstname, lastname, dateOfBirth, department, matricNumber;

    public Student(String firstname, String lastname, String dateOfBirth, String department, String matricNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.matricNumber = matricNumber;
    }

    public String getName() {

        return this.firstname + " " + this.lastname;

    }

    public void presentData() {

        System.out.printf("\n  STUDENT DATA FOR %s (%s) \n", this.getName(), this.matricNumber);

        System.out.printf("\nMatric Number: %s \n", this.matricNumber);
        System.out.printf("\nFirstname: %s \n", this.firstname);
        System.out.printf("\nLastname: %s \n", this.lastname);
        System.out.printf("\nDate of Birth: %s \n", this.dateOfBirth);
        System.out.printf("\nDepartment: %s \n", this.department);

        System.out.println("\nEnd \n");

    }
}

// End Student Class

public class StudentId {

    WeakHashMap<String, Student> students = new WeakHashMap<>();

    public static void main(String args[]) {

        System.out.println("\n  Student ID Portal ");
        Scanner scanner = new Scanner(System.in);

        StudentId portal = new StudentId();

        String ch = "";

        while (ch != "6") {

            ch = portal.getSelection(scanner);

            switch (ch) {

                case "1":
                    portal.showNumberOfEntries();
                    break;

                case "2":
                    portal.addNewEntry(scanner);
                    break;

                case "3":
                    portal.queryEntry(scanner);
                    break;
                case "4":
                    portal.updateEntry(scanner);
                    break;

                case "5":
                    portal.deleteEntry(scanner);
                    break;

                default:
                    return;
            }

        }

        scanner.close();
    }

    private void _addNew(Student student, String matricNumber) {
        this.students.put(matricNumber.toLowerCase(), student);
    }

    private void _removeOne(String matricNumber) {
        this.students.remove(matricNumber.toLowerCase());
    }

    private void _updateOne(String firstname, String lastname, String dateOfBirth, String department,
            String matricNumber) {

        Student student = this.students.get(matricNumber);
        student.firstname = firstname;
        student.lastname = lastname;
        student.dateOfBirth = dateOfBirth;
        student.department = department;
        student.matricNumber = matricNumber;

    }

    public void showNumberOfEntries() {
        int n = students.size();
        System.out.printf("\n There are %d entries.\n", n);
    }

    public void queryEntry(Scanner scanner) {

        System.out.print("\nEnter student's matric number: ");
        String matNo = scanner.next();

        if (!this.students.containsKey(matNo)) {
            System.out.printf("\nStudent with matriculation number '%s'  does not exist.\n", matNo);

        } else {

            Student entry = this.students.get(matNo);
            System.out.printf("\nEntry found (%s). \n", entry.getName());

        }

    }

    public void deleteEntry(Scanner scanner) {

        System.out.print("\nEnter student's matric number: ");
        String matNo = scanner.next();

        if (!this.students.containsKey(matNo)) {
            System.out.printf("\nStudent with matriculation number '%s'  does not exist.\n", matNo);

        } else {

            Student entry = this.students.get(matNo);

            System.out.printf("\nEntry found, deleting %s's record... \n", entry.getName());

            this._removeOne(matNo);
            System.out.printf("\nStudent deleted successfully. \n");

        }

    }

    public void updateEntry(Scanner scanner) {

        System.out.print("\nEnter student's matric number: ");
        String matNo = scanner.next();

        if (!this.students.containsKey(matNo)) {
            System.out.printf("\nStudent with matriculation number '%s'  does not exist.\n", matNo);

        } else {

            String firstname, lastname, dateOfBirth, department;

            System.out.println("\nFill in new student's data below\n");

            System.out.print("Enter new firstname: ");
            firstname = scanner.next();

            System.out.print("Enter new lastname: ");
            lastname = scanner.next();

            System.out.print("Enter new date of birth (dd-mm-yyyy): ");
            dateOfBirth = scanner.next();

            System.out.print("Enter new department: ");
            department = scanner.next();

            this._updateOne(firstname, lastname, dateOfBirth, department, matNo);

            System.out.println("\nStudent updated sucessfully.\n");

        }

    }

    public void addNewEntry(Scanner scanner) {

        String firstname, lastname, dateOfBirth, department, matricNumber;

        System.out.println("\nFill in student's data below\n");

        System.out.print("Enter matric number: ");
        matricNumber = scanner.next();

        System.out.print("Enter firstname: ");
        firstname = scanner.next();

        System.out.print("Enter lastname: ");
        lastname = scanner.next();

        System.out.print("Enter date of birth (dd-mm-yyyy): ");
        dateOfBirth = scanner.next();

        System.out.print("Enter department: ");
        department = scanner.next();

        Student newStudent = new Student(firstname, lastname, dateOfBirth, department, matricNumber);

        this._addNew(newStudent, matricNumber);

        System.out.println("\nStudent added sucessfully.\n");

    }

    public String getSelection(Scanner scanner) {

        String allowedMenus = "1 2 3 4 5 6";

        System.out.println(
                "\nSelect an operation: \n1 to Show number of entries\n2 to Add a new entry \n3 to Query an entry\n4 to Update an entry\n5 to Delete an entry\n6 to exit");

        System.out.print("\n-> ");

        try {

            String input = scanner.next();

            if (!allowedMenus.contains(input)) {

                System.out.println("Invalid selection, try again.");
                return this.getSelection(scanner);
            }

            return input;

        } catch (Exception err) {

            System.out.println("Invalid input, try again.");
            return this.getSelection(scanner);
        }

    }

}