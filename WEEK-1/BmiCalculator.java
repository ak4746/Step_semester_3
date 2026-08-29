public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid height or weight data.");
            return;
        }

        int totalPersons = heights.length;

        System.out.println("==========================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("==========================================================================");

        for (int i = 0; i < totalPersons; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s | %-12.2f | %-12.2f | %-10.2f | %-15s%n",
                    "Person " + (i + 1), height, weight, bmi, status);
        }

        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {
        System.out.println("=== Corporate Wellness Program: BMI Report ===\n");

        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.90};
        double[] weights = {70.0, 90.0, 68.0, 48.0, 82.0, 52.0, 110.0, 62.0, 75.0, 85.0};

        printWellnessReport(heights, weights);
    }
}
