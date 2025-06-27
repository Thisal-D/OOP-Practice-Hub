class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}

class GradeManager {
    private double[] grades = new double[10];
    private int gradeCount = 0;

    public void addGrade(double grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount++] = grade;
        }
    }

    public double calculateAverage() {
        if (gradeCount == 0)
            return 0;
        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return sum / gradeCount;
    }
}

class ReportPrinter {
    public void printReport(Student student, double average) {
        System.out.println("Student Report");
        System.out.println("Name: " + student.getName());
        System.out.println("ID  : " + student.getStudentId());
        System.out.println("Average Grade: " + average);
    }
}

class StudentFileSaver {
    public void saveToFile(Student student, String filename) {
        System.out.println("Saving student data for " + student.getName() + " to " + filename);
        // Actual file writing code can be added here if needed
    }
}

class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", "S123");
        GradeManager gradeManager = new GradeManager();
        ReportPrinter printer = new ReportPrinter();
        StudentFileSaver saver = new StudentFileSaver();

        // Add grades
        gradeManager.addGrade(85.0);
        gradeManager.addGrade(90.5);
        gradeManager.addGrade(78.0);

        // Calculate average
        double average = gradeManager.calculateAverage();

        // Print report
        printer.printReport(student, average);

        // Save to file (simulated)
        saver.saveToFile(student, "student_data.txt");
    }
}
