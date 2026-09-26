import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Delivery {
    protected String type;
    protected double weight;
    protected double distance;

    public Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 20.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 35.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

class DeliveryProcessor {
    public void process(List<Delivery> deliveries) {
        double grandTotal = 0.0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            grandTotal += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", delivery.getType(), fee);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            if (type.equalsIgnoreCase("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, distance));
            } else if (type.equalsIgnoreCase("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customsFee));
            }
        }
        DeliveryProcessor processor = new DeliveryProcessor();
        processor.process(deliveries);
        scanner.close();
    }
}
