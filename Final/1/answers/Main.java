 class Student {
    private String name;
    private String  studentId;

    public Student(String name,String studentId){
        this.name = name;
        this.studentId = studentId;
    }

    public String getname(){
        return name;      
    }
    public String getstudentId(){
        return studentId;
    }

}

class GradeManager {
    private double [] grades;
    private int gradeCount;

    public void addGrade(double grade){
        if (gradeCount < grades.length) {
            grades[gradeCount++] = grade;
        }
    }

    public double calculateAverage () {
        if (gradeCount == 0) {
            return 0;
        } 
        double sum =0;
        for (int i = 0; i < gradeCount; i++) {
            sum+= grades[i];
        }
        return sum / gradeCount;
    }
}


class printStudentDetails {

    public void printReport(Student student ,  double average){
        System.out.println("Student report");
        System.out.println("Name: " + student.getname());
        System.out.println("ID:" +student.getstudentId());
        System.out.println("Average Grade:" + average);
    }

}

class saveToFile {
 public void saveToFile(String filename) {
        // Code to save student data to file
        System.out.println("Saving student data to " + filename);
    }
}

class Main {
    public static void main(String[] args) {
    
        Student student = new Student("Kamal", "0012");
        GradeManager gradeManager = new GradeManager();
        gradeManager.addGrade(89);
        gradeManager.addGrade(67);
        double avg=gradeManager.calculateAverage();


        printStudentDetails printStudentDetails = new printStudentDetails();
        printStudentDetails.printReport(student ,avg);

        
    
    }

}





