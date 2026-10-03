import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class MovieTicket {
    private static final double CONVENIENCE_FEE = 20.0;
    private String seatType;
    protected int count;

    public MovieTicket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public abstract double getBasePrice();

    public double calculateTotalAmount() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

class TicketCounter {
    public static void processBookings(List<MovieTicket> tickets) {
        double total = 0.0;
        for (MovieTicket ticket : tickets) {
            double amount = ticket.calculateTotalAmount();
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", ticket.getSeatType(), amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<MovieTicket> tickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            if (seat.equalsIgnoreCase("REGULAR")) {
                tickets.add(new RegularTicket(count));
            } else if (seat.equalsIgnoreCase("PREMIUM")) {
                tickets.add(new PremiumTicket(count));
            } else if (seat.equalsIgnoreCase("RECLINER")) {
                tickets.add(new ReclinerTicket(count));
            }
        }
        TicketCounter.processBookings(tickets);
        scanner.close();
    }
}
