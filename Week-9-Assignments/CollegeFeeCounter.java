import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;
}

abstract class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBaseFee();

    public double calculateTotalFee() {
        double fee = calculateBaseFee();
        if (this instanceof BusUser) {
            fee += BusUser.TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholarStudent extends Student implements BusUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 20000.0;
    }
}

class FeeCounter {
    public static void processFees(List<Student> students) {
        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            totalCollected += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", student.getName(), fee);
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students.add(new DayScholarStudent(name));
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students.add(new HostellerStudent(name));
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students.add(new ScholarshipStudent(name));
            }
        }
        FeeCounter.processFees(students);
        scanner.close();
    }
}
