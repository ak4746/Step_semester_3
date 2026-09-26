import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

class PayrollBonusSystem {
    public void processBonuses(List<Employee> employees) {
        double grandTotal = 0.0;
        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            grandTotal += bonus;
            System.out.printf(Locale.US, "%s: %.2f%n", employee.getName(), bonus);
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", grandTotal);
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            if (type.equalsIgnoreCase("FULLTIME")) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if (type.equalsIgnoreCase("PARTTIME")) {
                employees.add(new PartTimeEmployee(name, salary));
            } else if (type.equalsIgnoreCase("INTERN")) {
                employees.add(new InternEmployee(name, salary));
            }
        }
        PayrollBonusSystem system = new PayrollBonusSystem();
        system.processBonuses(employees);
        scanner.close();
    }
}
