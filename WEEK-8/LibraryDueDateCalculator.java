import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getBorrowingDurationDays();

    public LocalDate calculateDueDate(LocalDate fromDate) {
        return fromDate.plusDays(getBorrowingDurationDays());
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDurationDays() {
        return 14;
    }
}

class Dvd extends LibraryItem {
    public Dvd(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDurationDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDurationDays() {
        return 3;
    }
}

class LibrarySystem {
    public void processDueDates(List<LibraryItem> items, LocalDate currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        String firstLine = scanner.nextLine().trim();
        if (firstLine.isEmpty()) {
            return;
        }
        int n = Integer.parseInt(firstLine);
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            int spaceIdx = line.indexOf(' ');
            if (spaceIdx == -1) {
                continue;
            }
            String type = line.substring(0, spaceIdx).trim();
            String rawTitle = line.substring(spaceIdx + 1).trim();
            if (rawTitle.startsWith("\"") && rawTitle.endsWith("\"") && rawTitle.length() >= 2) {
                rawTitle = rawTitle.substring(1, rawTitle.length() - 1);
            }
            if (type.equalsIgnoreCase("BOOK")) {
                items.add(new Book(rawTitle));
            } else if (type.equalsIgnoreCase("DVD")) {
                items.add(new Dvd(rawTitle));
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items.add(new Magazine(rawTitle));
            }
        }
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        LibrarySystem system = new LibrarySystem();
        system.processDueDates(items, currentDate);
        scanner.close();
    }
}
