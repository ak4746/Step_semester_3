import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine().replace("[", "").replace("]", "").trim();
            if (!input.isEmpty()) {
                String[] tokens = input.split(",");
                int[] arr = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    arr[i] = Integer.parseInt(tokens[i].trim());
                }
                reverse(arr);
                System.out.println(Arrays.toString(arr));
            }
        }
        scanner.close();
    }
}
