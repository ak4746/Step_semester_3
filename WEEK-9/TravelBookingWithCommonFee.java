import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    private String mode;
    protected double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();
            if (mode.equalsIgnoreCase("BUS")) {
                bookings.add(new BusBooking(distanceKm));
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings.add(new TrainBooking(distanceKm));
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings.add(new FlightBooking(distanceKm));
            }
        }
        for (TravelBooking booking : bookings) {
            System.out.printf(Locale.US, "%s: %.2f%n", booking.getMode(), booking.calculateTotalFare());
        }
        scanner.close();
    }
}
