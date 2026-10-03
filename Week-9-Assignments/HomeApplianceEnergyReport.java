import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface SaverModeSupport {
    default double applySaverMode(double units) {
        return units * 0.75;
    }
}

abstract class Appliance {
    private static final double RATE_PER_UNIT = 8.0;
    private String name;
    protected double powerRating;
    protected double hours;

    public Appliance(String name, double powerRating, double hours) {
        this.name = name;
        this.powerRating = powerRating;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public boolean supportsSaverMode() {
        return this instanceof SaverModeSupport;
    }

    public double calculateUnits(boolean saverMode) {
        double units = (powerRating * hours) / 1000.0;
        if (saverMode && this instanceof SaverModeSupport) {
            units = ((SaverModeSupport) this).applySaverMode(units);
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * RATE_PER_UNIT;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super("FRIDGE", 150.0, hours);
    }
}

class AirConditioner extends Appliance implements SaverModeSupport {
    public AirConditioner(double hours) {
        super("AC", 1500.0, hours);
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super("TV", 100.0, hours);
    }
}

class WashingMachine extends Appliance implements SaverModeSupport {
    public WashingMachine(double hours) {
        super("WASHER", 500.0, hours);
    }
}

class ApplianceUsage {
    private Appliance appliance;
    private boolean saverModeRequested;

    public ApplianceUsage(Appliance appliance, boolean saverModeRequested) {
        this.appliance = appliance;
        this.saverModeRequested = saverModeRequested;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public boolean isSaverModeRequested() {
        return saverModeRequested;
    }
}

class EnergyReporter {
    public static void generateReport(List<ApplianceUsage> usages) {
        double totalCost = 0.0;
        for (ApplianceUsage usage : usages) {
            Appliance appliance = usage.getAppliance();
            boolean isSaver = usage.isSaverModeRequested();
            if (isSaver && !appliance.supportsSaverMode()) {
                System.out.printf("%s: saver mode not supported%n", appliance.getName());
            } else {
                double units = appliance.calculateUnits(isSaver);
                double cost = appliance.calculateCost(units);
                totalCost += cost;
                System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n",
                        appliance.getName(), units, cost);
            }
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<ApplianceUsage> usages = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double hours = scanner.nextDouble();
            String rest = scanner.nextLine().trim();
            boolean isSaver = false;
            if (!rest.isEmpty()) {
                String[] tokens = rest.split("\\s+");
                if (tokens.length > 0 && tokens[0].equalsIgnoreCase("SAVER")) {
                    isSaver = true;
                }
            }
            Appliance appliance = null;
            if (type.equalsIgnoreCase("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equalsIgnoreCase("AC")) {
                appliance = new AirConditioner(hours);
            } else if (type.equalsIgnoreCase("TV")) {
                appliance = new Television(hours);
            } else if (type.equalsIgnoreCase("WASHER")) {
                appliance = new WashingMachine(hours);
            }
            if (appliance != null) {
                usages.add(new ApplianceUsage(appliance, isSaver));
            }
        }
        EnergyReporter.generateReport(usages);
        scanner.close();
    }
}
