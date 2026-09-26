import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class CustomerBill {
    protected String customerType;
    protected double billAmount;

    public CustomerBill(String customerType, double billAmount) {
        this.customerType = customerType;
        this.billAmount = billAmount;
    }

    public String getCustomerType() {
        return customerType;
    }

    public abstract double calculateFinalAmount();
}

class StudentBill extends CustomerBill {
    public StudentBill(double billAmount) {
        super("STUDENT", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.90;
    }
}

class StaffBill extends CustomerBill {
    public StaffBill(double billAmount) {
        super("STAFF", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.95;
    }
}

class GuestBill extends CustomerBill {
    public GuestBill(double billAmount) {
        super("GUEST", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount + 10.0;
    }
}

class BillingCounter {
    public void processBills(List<CustomerBill> bills) {
        double grandTotal = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf(Locale.US, "%s: %.2f%n", bill.getCustomerType(), finalAmount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<CustomerBill> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equalsIgnoreCase("STUDENT")) {
                bills.add(new StudentBill(amount));
            } else if (type.equalsIgnoreCase("STAFF")) {
                bills.add(new StaffBill(amount));
            } else if (type.equalsIgnoreCase("GUEST")) {
                bills.add(new GuestBill(amount));
            }
        }
        BillingCounter counter = new BillingCounter();
        counter.processBills(bills);
        scanner.close();
    }
}
