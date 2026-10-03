import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class GardenPlot {
    private String owner;
    private String shapeType;

    public GardenPlot(String owner, String shapeType) {
        this.owner = owner;
        this.shapeType = shapeType;
    }

    public String getOwner() {
        return owner;
    }

    public String getShapeType() {
        return shapeType;
    }

    public abstract double calculateArea();
}

class CirclePlot extends GardenPlot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends GardenPlot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends GardenPlot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class GardenReport {
    public static void generateReport(List<GardenPlot> plots) {
        double totalArea = 0.0;
        for (GardenPlot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;
            System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.getOwner(), plot.getShapeType(), area);
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        List<GardenPlot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            if (shape.equalsIgnoreCase("CIRCLE")) {
                double radius = scanner.nextDouble();
                plots.add(new CirclePlot(owner, radius));
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                plots.add(new RectanglePlot(owner, length, width));
            } else if (shape.equalsIgnoreCase("TRIANGLE")) {
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                plots.add(new TrianglePlot(owner, base, height));
            }
        }
        GardenReport.generateReport(plots);
        scanner.close();
    }
}
