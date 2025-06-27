import java.util.ArrayList;

// 1. Interface: Registrable
interface Registrable {
    String getCourseCode();

    String getCourseTitle();

    void displayCourseInfo();
}

// 2. Course class
class Course implements Registrable {
    private String courseCode;
    private String courseTitle;
    private String instructor;
    private static String semester;

    public Course(String courseCode, String courseTitle, String instructor) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.instructor = instructor;
    }

    // Static method to set semester
    public static void setSemester(String sem) {
        semester = sem;
    }

    // Getter for semester
    public String getSemester() {
        return semester;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String getCourseTitle() {
        return courseTitle;
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Course Code   : " + courseCode);
        System.out.println("Course Title  : " + courseTitle);
        System.out.println("Instructor    : " + instructor);
        System.out.println("Semester      : " + getSemester());
        System.out.println("----------------------------");
    }
}

// 3. CourseManager class
class CourseManager {
    private ArrayList<Course> courseList;

    public CourseManager() {
        courseList = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courseList.add(c);
    }

    public void displayAllCourses() {
        System.out.println("=== Registered Courses ===");
        for (Course c : courseList) {
            c.displayCourseInfo();
        }
    }
}

// 4. Main class
class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Set semester
        Course.setSemester("Fall 2025");

        // Create course objects
        Course c1 = new Course("CS101", "Introduction to Programming", "Dr. Smith");
        Course c2 = new Course("MA201", "Discrete Mathematics", "Prof. Johnson");
        Course c3 = new Course("CS202", "Data Structures", "Dr. Lee");

        // Create CourseManager and register courses
        CourseManager manager = new CourseManager();
        manager.addCourse(c1);
        manager.addCourse(c2);
        manager.addCourse(c3);

        // Display all course info
        manager.displayAllCourses();
    }
}
