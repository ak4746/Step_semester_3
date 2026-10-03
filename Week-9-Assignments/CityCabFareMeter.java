import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface NightServiceable {
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100.0;
    private String type;
    protected double km;

    public Cab(String type, double km) {
        this.type = type;
        this.km = km;
    }

    public String getType() {
        return type;
    }

    public abstract double getRatePerKm();

    public boolean supportsNightService() {
        return this instanceof NightServiceable;
    }

    public double calculateFare(String time) {
        double baseFare = Math.max(MINIMUM_FARE, km * getRatePerKm());
        if (time.equalsIgnoreCase("NIGHT")) {
            return baseFare * 1.20;
        }
        return baseFare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super("MINI", km);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super("SEDAN", km);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double km) {
        super("SUV", km);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

class Trip {
    private Cab cab;
    private String time;

    public Trip(Cab cab, String time) {
        this.cab = cab;
        this.time = time;
    }

    public Cab getCab() {
        return cab;
    }

    public String getTime() {
        return time;
    }
}

class FareMeter {
    public static void processTrips(List<Trip> trips) {
        double total = 0.0;
        for (Trip trip : trips) {
            Cab cab = trip.getCab();
            String time = trip.getTime();
            if (time.equalsIgnoreCase("NIGHT") && !cab.supportsNightService()) {
                System.out.printf("%s: night service not available%n", cab.getType());
            } else {
                double fare = cab.calculateFare(time);
                total += fare;
                System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            Cab cab = null;
            if (cabType.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km);
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km);
            } else if (cabType.equalsIgnoreCase("SUV")) {
                cab = new SuvCab(km);
            }
            if (cab != null) {
                trips.add(new Trip(cab, time));
            }
        }
        FareMeter.processTrips(trips);
        scanner.close();
    }
}
