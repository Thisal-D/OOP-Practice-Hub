class Person {
    protected String personID;
    protected String name;

    public Person(String personID, String name) {
        this.personID = personID;
        this.name = name;
    }

    public void displayPersonDetails() {
        System.out.println("Person ID: " + personID);
        System.out.println("Name: " + name);
    }
}

class Course {
    private String courseCode;
    private String courseTitle;

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    public void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Title: " + courseTitle);
    }
}

class Student extends Person {
    private Course course;
    private String grade;

    public Student(String personID, String name, Course course, String grade) {
        super(personID, name);
        this.course = course;
        this.grade = grade;
    }

    public void displayStudentDetails() {
        displayPersonDetails();
        course.displayCourseDetails();
        System.out.println("Grade: " + grade);
    }
}

class UniversityApp {
    public static void main(String[] args) {
        // Step 1: Create Course object
        Course course = new Course("CS101", "Introduction to Computer Science");

        // Step 2: Create Student object using the course object
        Student student = new Student("P001", "Alice Johnson", course, "A");

        // Step 3: Display all details
        student.displayStudentDetails();
    }
}
