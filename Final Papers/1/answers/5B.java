
import java.util.ArrayList;
import java.util.Scanner;

// 1. Interface
interface Enrollable {
    String getStudentID();

    String getName();

    void displayDetails();
}

// 2. Student class implementing Enrollable
class Student implements Enrollable {
    private String studentID;
    private String name;
    private String course;
    private static int batch;

    public Student(String studentID, String name, String course) {
        this.studentID = studentID;
        this.name = name;
        this.course = course;
    }

    public static void setBatch(int b) {
        batch = b;
    }

    public int getBatch() {
        return batch;
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID : " + studentID);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Batch      : " + batch);
        System.out.println();
    }
}

// 3. EnrollmentSystem class
class EnrollmentSystem {
    private ArrayList<Student> students;

    public EnrollmentSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayAllStudents() {
        System.out.println("\n=== Student Enrollment Details ===");
        for (Student s : students) {
            s.displayDetails();
        }
    }
}

// 4. Main Class
class StudentEnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Set batch using user input
        System.out.print("Enter batch year: ");
        int batchYear = sc.nextInt();
        sc.nextLine(); // consume newline
        Student.setBatch(batchYear);

        // Create enrollment system
        EnrollmentSystem system = new EnrollmentSystem();

        // Input 3 student records
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nEnter details for student " + i + ":");

            System.out.print("Student ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            Student s = new Student(id, name, course);
            system.addStudent(s);
        }

        // Display all students
        system.displayAllStudents();

        sc.close();
    }
}
