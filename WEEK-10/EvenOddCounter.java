import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replace("[", "").replace("]", "").trim();
        int evenCount = 0;
        int oddCount = 0;

        if (!input.isEmpty()) {
            String[] tokens = input.split(",");
            for (String token : tokens) {
                int num = Integer.parseInt(token.trim());
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
        scanner.close();
    }
}
