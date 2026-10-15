public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentTotal += grid[i][j];
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }

        return new int[]{bestRow, maxTotal};
    }

    public static String getBusiestRowReport(int[][] grid) {
        int[] result = busiestRow(grid);
        return "Row " + result[0] + ", Total " + result[1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
