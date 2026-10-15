class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public char determineGrade() {
        double avg = calculateAverage();
        if (avg >= 75.0) {
            return 'B';
        } else if (avg >= 60.0) {
            return 'C';
        } else if (avg >= 40.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade = determineGrade();
        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }
}

public class ResultCardGenerator {
    public static void main(String[] args) {
        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});

        s1.printResultCard();
        s2.printResultCard();
    }
}
