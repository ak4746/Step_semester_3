public class ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundDuplicate = false;
        int n = seatNumbers.length;

        for (int i = 0; i < n; i++) {
            boolean alreadySeen = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadySeen = true;
                    break;
                }
            }

            if (alreadySeen) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
