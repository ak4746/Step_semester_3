public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] res1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("[" + res1[0] + ", " + res1[1] + "]");

        int[] res2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("[" + res2[0] + ", " + res2[1] + "]");
    }
}