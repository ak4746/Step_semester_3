public class ClassAttendanceTracker {

    public static int[] attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentCount, longestStreak};
    }

    public static void printSummary(int[] days) {
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }

    public static void main(String[] args) {
        int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
        printSummary(sample1);

        int[] sample2 = {0, 0, 0};
        printSummary(sample2);
    }
}
