import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public SubscriptionPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

class StreamingService {
    public void processRenewals(List<SubscriptionPlan> subscriptions) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (SubscriptionPlan plan : subscriptions) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getSubscriberName() + ": " + renewalDate.format(formatter));
        }
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<SubscriptionPlan> subscriptions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr, formatter);
            if (planType.equalsIgnoreCase("BASIC")) {
                subscriptions.add(new BasicPlan(name, startDate));
            } else if (planType.equalsIgnoreCase("STANDARD")) {
                subscriptions.add(new StandardPlan(name, startDate));
            } else if (planType.equalsIgnoreCase("PREMIUM")) {
                subscriptions.add(new PremiumPlan(name, startDate));
            }
        }
        StreamingService service = new StreamingService();
        service.processRenewals(subscriptions);
        scanner.close();
    }
}
