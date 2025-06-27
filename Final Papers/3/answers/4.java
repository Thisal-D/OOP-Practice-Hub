// Subject.java
class Subject {
    private String subjectCode;
    private String subjectName;
    private Teacher teacher;

    public Subject(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void displaySubjectDetails() {
        System.out.println("Subject Code: " + subjectCode);
        System.out.println("Subject Name: " + subjectName);
        if (teacher != null) {
            System.out.println("Assigned Teacher: " + teacher.getTeacherName());
        } else {
            System.out.println("No teacher assigned yet.");
        }
        System.out.println();
    }
}

// Teacher.java
class Teacher {
    private String teacherID;
    private String teacherName;
    private Subject[] subjects;
    private int subjectCount;

    public Teacher(String teacherID, String teacherName) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.subjects = new Subject[4];
        this.subjectCount = 0;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void addSubject(Subject subject) {
        if (subjectCount < 4) {
            subjects[subjectCount] = subject;
            subjectCount++;
            subject.setTeacher(this); // Bidirectional link
        } else {
            System.out.println("Cannot assign more than 4 subjects to a teacher.");
        }
    }

    public void displayTeacherDetails() {
        System.out.println("Teacher ID: " + teacherID);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Number of Assigned Subjects: " + subjectCount);
        System.out.println("Assigned Subjects:");
        for (int i = 0; i < subjectCount; i++) {
            subjects[i].displaySubjectDetails();
        }
    }
}

// Main class
class TeacherSubjectSystem {
    public static void main(String[] args) {
        // 1. Create Subject Objects
        Subject s1 = new Subject("MAT101", "Mathematics");
        Subject s2 = new Subject("PHY101", "Physics");
        Subject s3 = new Subject("CHE101", "Chemistry");
        Subject s4 = new Subject("BIO101", "Biology");

        // 2. Create Teacher Object
        Teacher t1 = new Teacher("T001", "Dr. Alice Johnson");

        // 3. Assign Subjects to Teacher
        t1.addSubject(s1);
        t1.addSubject(s2);
        t1.addSubject(s3);
        t1.addSubject(s4);

        // 4. Display Results
        System.out.println("=== Teacher Details ===");
        t1.displayTeacherDetails();

        System.out.println("=== Displaying a Subject's Details ===");
        s2.displaySubjectDetails(); // Demonstrate subject-to-teacher link
    }
}
