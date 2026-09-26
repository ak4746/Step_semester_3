import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class ParkedVehicle {
    protected String vehicleType;
    protected int hours;

    public ParkedVehicle(String vehicleType, int hours) {
        this.vehicleType = vehicleType;
        this.hours = hours;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public abstract double calculateCharge();
}

class Bike extends ParkedVehicle {
    public Bike(int hours) {
        super("BIKE", hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends ParkedVehicle {
    public Car(int hours) {
        super("CAR", hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends ParkedVehicle {
    public Truck(int hours) {
        super("TRUCK", hours);
    }

    @Override
    public double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
}

class ParkingSystem {
    public void processVehicles(List<ParkedVehicle> vehicles) {
        double grandTotal = 0.0;
        for (ParkedVehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            grandTotal += charge;
            System.out.printf(Locale.US, "%s: %.2f%n", vehicle.getVehicleType(), charge);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<ParkedVehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            if (type.equalsIgnoreCase("BIKE")) {
                vehicles.add(new Bike(hours));
            } else if (type.equalsIgnoreCase("CAR")) {
                vehicles.add(new Car(hours));
            } else if (type.equalsIgnoreCase("TRUCK")) {
                vehicles.add(new Truck(hours));
            }
        }
        ParkingSystem system = new ParkingSystem();
        system.processVehicles(vehicles);
        scanner.close();
    }
}
