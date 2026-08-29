public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0], profit = 0;
        for (int p : prices) {
            if (p < min) min = p;
            else if (p - min > profit) profit = p - min;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("Profit 1: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Profit 2: " + maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}