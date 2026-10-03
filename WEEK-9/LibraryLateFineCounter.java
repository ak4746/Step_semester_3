import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class LibraryItem {
    private String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

class FineCounter {
    public static void displayFines(List<LibraryItem> items) {
        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", totalFines);
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            if (type.equalsIgnoreCase("BOOK")) {
                items.add(new BookItem(title, daysLate));
            } else if (type.equalsIgnoreCase("DVD")) {
                items.add(new DvdItem(title, daysLate));
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items.add(new MagazineItem(title, daysLate));
            }
        }
        FineCounter.displayFines(items);
        scanner.close();
    }
}
