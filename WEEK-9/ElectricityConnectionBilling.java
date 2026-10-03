import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class ElectricityConnection {
    private String type;
    protected double units;

    public ElectricityConnection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public double getUnits() {
        return units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

class BillingSystem {
    public static void generateBillReport(List<ElectricityConnection> connections) {
        double total = 0.0;
        for (ElectricityConnection connection : connections) {
            double bill = connection.calculateBill();
            total += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", connection.getType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            if (type.equalsIgnoreCase("HOME")) {
                connections.add(new HomeConnection(units));
            } else if (type.equalsIgnoreCase("SHOP")) {
                connections.add(new ShopConnection(units));
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connections.add(new FactoryConnection(units));
            }
        }
        BillingSystem.generateBillReport(connections);
        scanner.close();
    }
}
