public class CompanyEmployee {
    public String empName;
    public double salary;
    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new CompanyEmployee("Aman", 40000);
        new CompanyEmployee("Priya", 50000);
        new CompanyEmployee("Rohan", 60000);

        CompanyEmployee.printCompanyInfo();
    }
}
