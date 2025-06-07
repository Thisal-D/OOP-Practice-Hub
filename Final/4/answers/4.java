class Company {
    private String companyID;
    private String companyName;
    private Employee[] employees;
    private int employeeCount;

    public Company(String companyID, String companyName) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.employees = new Employee[5];
        this.employeeCount = 0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addEmployee(Employee employee) {
        if (employeeCount < 5) {
            employees[employeeCount] = employee;
            employeeCount++;
            employee.setCompany(this); // Bidirectional link
        } else {
            System.out.println("Cannot add more employees. Company is full.");
        }
    }

    public void displayCompanyDetails() {
        System.out.println("Company ID: " + companyID);
        System.out.println("Company Name: " + companyName);
        System.out.println("Number of Employees: " + employeeCount);
        System.out.println("Employee Details:");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployeeDetails();
        }
    }
}

class Employee {
    private String employeeID;
    private String employeeName;
    private Company company;

    public Employee(String employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.company = null;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Employee Name: " + employeeName);
        if (company != null) {
            System.out.println("Company: " + company.getCompanyName());
        } else {
            System.out.println("Company: Not assigned");
        }
        System.out.println("----------------------------");
    }
}

class CompanyEmployeeManagement {
    public static void main(String[] args) {
        // Step 1: Create Employee objects
        Employee emp1 = new Employee("E101", "Alice Johnson");
        Employee emp2 = new Employee("E102", "Bob Smith");
        Employee emp3 = new Employee("E103", "Carol White");
        Employee emp4 = new Employee("E104", "David Brown");

        // Step 2: Create Company object
        Company company = new Company("C001", "TechNova Solutions");

        // Step 3: Add Employees to the Company
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        company.addEmployee(emp4);

        // Step 4: Display Company Details
        System.out.println("=== Company Information ===");
        company.displayCompanyDetails();

        // Step 5: Display details from Employee perspective
        System.out.println("\n=== Individual Employee Details ===");
        emp2.displayEmployeeDetails(); // Example employee
    }
}
