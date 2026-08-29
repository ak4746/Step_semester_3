public class TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < total; i++) {
            if (i < typed.length() && original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = i < typed.length() ? typed.charAt(i) : ' ';
            }
        }

        double accuracy = total == 0 ? 100.0 : ((double) matched / total) * 100.0;

        if (firstMismatchPos == -1 && original.length() == typed.length()) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, total, accuracy, firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
