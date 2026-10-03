import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    private String type;
    protected double weightKg;
    protected double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateShippingCharge();

    public double getInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + getInsurance();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return (40.0 + (10.0 * weightKg)) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class ShippingDesk {
    public static void processParcels(List<Parcel> parcels) {
        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.calculateTotal();
            grandTotal += total;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weightKg = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            if (type.equalsIgnoreCase("STANDARD")) {
                parcels.add(new StandardParcel(weightKg, declaredValue));
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels.add(new ExpressParcel(weightKg, declaredValue));
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels.add(new FragileParcel(weightKg, declaredValue));
            }
        }
        ShippingDesk.processParcels(parcels);
        scanner.close();
    }
}
