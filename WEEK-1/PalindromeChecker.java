public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return checkRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void verifyPalindrome(String text) {
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        String iterResult = iterative ? "Palindrome" : "Not Palindrome";
        String recurResult = recursive ? "Palindrome" : "Not Palindrome";
        String arrResult = arrayReversal ? "Palindrome" : "Not Palindrome";

        System.out.printf("\"%s\"%nIterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                text, iterResult, recurResult, arrResult);
    }

    public static void main(String[] args) {
        System.out.println("=== QA Text Verification: Palindrome Checker ===\n");

        verifyPalindrome("madam");
        verifyPalindrome("hello");
        verifyPalindrome("racecar");
        verifyPalindrome("step");
        verifyPalindrome("deified");
    }
}
