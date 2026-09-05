import java.util.*;
import java.util.stream.*;

record Candidate(String name, double cgpa, int codingScore) {
    double score() {
        return cgpa * 10.0 + codingScore * 0.5;
    }

    boolean isEligible() {
        return cgpa >= 7.5 || (cgpa >= 6.5 && codingScore >= 60);
    }
}

public class PlacementDriveEngine {

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null)
            return "";

        var valid = Arrays.stream(candidates)
                .filter(c -> c != null && c.isEligible())
                .sorted(Comparator.comparingDouble(Candidate::score).reversed())
                .toList();

        return IntStream.range(0, valid.size())
                .mapToObj(i -> String.format(Locale.US, "%d. %s (%.1f)", i + 1, valid.get(i).name(),
                        valid.get(i).score()))
                .collect(Collectors.joining(" | "));
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90), // Ineligible (cgpa < 6.5)
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}