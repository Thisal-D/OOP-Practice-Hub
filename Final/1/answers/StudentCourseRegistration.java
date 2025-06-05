
import java.util.Scanner;

class Course {
    private String courseCode;
    private String courseTitle;

    // Parameterized constructor
    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    // Method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Title: " + courseTitle);
        System.out.println();
    }
}

class Student {
    private String studentID;
    private String studentName;
    private Course[] enrolledCourses = new Course[3];
    private int courseCount = 0;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    // Method to enroll in a course
    public void enrollCourse(Course course) {
        if (courseCount < 3) {
            enrolledCourses[courseCount] = course;
            courseCount++;
        } else {
            System.out.println("Cannot enroll in more than 3 courses.");
        }
    }

    // Method to display student details and enrolled courses
    public void displayStudentDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
        System.out.println("Number of Enrolled Courses: " + courseCount);
        System.out.println("Enrolled Course Details:");
        System.out.println("--------------------------");
        for (int i = 0; i < courseCount; i++) {
            enrolledCourses[i].displayCourseDetails();
        }
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get student details
        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        // Create student object
        Student student = new Student(studentID, studentName);

        // Enroll in 3 courses
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nEnter details for Course " + i + ":");
            System.out.print("Course Code: ");
            String code = sc.nextLine();

            System.out.print("Course Title: ");
            String title = sc.nextLine();

            Course course = new Course(code, title);
            student.enrollCourse(course);
        }

        // Display student and enrolled course details
        student.displayStudentDetails();

        sc.close();
    }
}
