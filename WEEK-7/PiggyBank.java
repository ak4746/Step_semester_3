public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + (int) pb.getSavings());
        pb.withdraw(30);
        System.out.println("savings = " + (int) pb.getSavings());
        pb.withdraw(500);
        System.out.println("savings = " + (int) pb.getSavings());
    }
}
