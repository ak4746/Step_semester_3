import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class TransportJourney {
    protected String transportType;
    protected double distance;

    public TransportJourney(String transportType, double distance) {
        this.transportType = transportType;
        this.distance = distance;
    }

    public String getTransportType() {
        return transportType;
    }

    public abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

class PublicTransportSystem {
    public void processJourneys(List<TransportJourney> journeys) {
        double grandTotalFare = 0.0;
        for (TransportJourney journey : journeys) {
            double fare = journey.calculateFare();
            grandTotalFare += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", journey.getTransportType(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotalFare);
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<TransportJourney> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            if (type.equalsIgnoreCase("BUS")) {
                journeys.add(new BusJourney(distance));
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journeys.add(new TrainJourney(distance));
            } else if (type.equalsIgnoreCase("METRO")) {
                double factor = scanner.nextDouble();
                journeys.add(new MetroJourney(distance, factor));
            }
        }
        PublicTransportSystem system = new PublicTransportSystem();
        system.processJourneys(journeys);
        scanner.close();
    }
}
