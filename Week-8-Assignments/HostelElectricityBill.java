import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class HostelRoom {
    protected String roomType;
    protected int units;

    public HostelRoom(String roomType, int units) {
        this.roomType = roomType;
        this.units = units;
    }

    public String getRoomType() {
        return roomType;
    }

    public abstract double calculateBill();
}

class SingleRoom extends HostelRoom {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends HostelRoom {
    public AcRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

class HostelBillingSystem {
    public void processRooms(List<HostelRoom> rooms) {
        double grandTotal = 0.0;
        for (HostelRoom room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", room.getRoomType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<HostelRoom> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equalsIgnoreCase("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equalsIgnoreCase("SHARED")) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equalsIgnoreCase("AC")) {
                rooms.add(new AcRoom(units));
            }
        }
        HostelBillingSystem system = new HostelBillingSystem();
        system.processRooms(rooms);
        scanner.close();
    }
}
