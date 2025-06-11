import java.util.ArrayList;

// Interface: Employable
interface Employable {
    String getEmployeeID();

    String getEmployeeName();

    void displayEmployeeDetails();
}

// Employee class implementing Employable
class Employee implements Employable {
    private String employeeID;
    private String employeeName;
    private String department;
    private static String companyName;

    public Employee(String employeeID, String employeeName, String department) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("ID: " + employeeID);
        System.out.println("Name: " + employeeName);
        System.out.println("Department: " + department);
        System.out.println("Company: " + companyName);
        System.out.println("---------------------------");
    }
}

// EmployeeManager class
class EmployeeManager {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee e) {
        employeeList.add(e);
    }

    public void addEmployeeAtIndex(int index, Employee e) {
        if (index >= 0 && index <= employeeList.size()) {
            employeeList.add(index, e);
        } else {
            System.out.println("Invalid index to add employee.");
        }
    }

    public void removeEmployeeAtIndex(int index) {
        if (index >= 0 && index < employeeList.size()) {
            employeeList.remove(index);
        } else {
            System.out.println("Invalid index to remove employee.");
        }
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }

    public void setEmployeeAtIndex(int index, Employee e) {
        if (index >= 0 && index < employeeList.size()) {
            employeeList.set(index, e);
        } else {
            System.out.println("Invalid index to update employee.");
        }
    }

    public void displayAllEmployees() {
        System.out.println("=== Employee List ===");
        for (Employee e : employeeList) {
            e.displayEmployeeDetails();
        }
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        // Set shared company name
        Employee.setCompanyName("ABC Company");

        // Create employees
        Employee emp1 = new Employee("E001", "Dilshan", "HR");
        Employee emp2 = new Employee("E002", "Asma", "IT");
        Employee emp3 = new Employee("E003", "Tharusha", "Finance");
        Employee emp4 = new Employee("E004", "Alwis", "Marketing");
        Employee emp5 = new Employee("E005", "Lochana", "Management");
        Employee emp6 = new Employee("E006", "Senud", "HR");

        // Employee Manager
        EmployeeManager manager = new EmployeeManager();

        // Add employees
        manager.addEmployee(emp1); // add at end
        manager.addEmployee(emp2); // add at end
        manager.addEmployee(emp3); // add at end
        manager.addEmployeeAtIndex(5, emp4); // insert at index 5
        manager.addEmployeeAtIndex(3, emp4); // insert at index 3
        manager.addEmployeeAtIndex(3, emp5); // insert at index 3
        manager.addEmployeeAtIndex(1, emp6); // insert at index 1

        // Display before changes
        manager.displayAllEmployees();

        // Remove one employee
        manager.removeEmployeeAtIndex(2); // removes emp2 USING index
        manager.removeEmployee(emp6); // removes emp6 using object

        // Update (replace) an employee
        manager.setEmployeeAtIndex(1, emp4); // replaces emp3 with emp4
        manager.removeEmployeeAtIndex(3); // remove duplicated emp4

        // Display after updates
        System.out.println("=== Updated Employees ===");
        manager.displayAllEmployees();
    }
}
