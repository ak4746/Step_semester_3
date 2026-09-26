import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class ExamQuestion {
    protected String questionType;
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public ExamQuestion(String questionType, String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionType = questionType;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getQuestionType() {
        return questionType;
    }

    public abstract double evaluateScore();
}

class MultipleChoiceQuestion extends ExamQuestion {
    public MultipleChoiceQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("MCQ", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class TrueFalseQuestion extends ExamQuestion {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("TF", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("ESSAY", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        String studentLower = studentAnswer.toLowerCase();
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        for (String kw : keywords) {
            String cleanKw = kw.trim().toLowerCase();
            if (!cleanKw.isEmpty() && studentLower.contains(cleanKw)) {
                matchedCount++;
            }
        }
        if (matchedCount >= 2) {
            return points * 0.75;
        } else if (matchedCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}

class ExamGrader {
    public void grade(List<ExamQuestion> questions) {
        double totalScore = 0.0;
        for (ExamQuestion q : questions) {
            double score = q.evaluateScore();
            totalScore += score;
            System.out.printf(Locale.US, "%s: %.2f%n", q.getQuestionType(), score);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", totalScore);
    }
}

public class ExamQuestionGrader {
    private static List<String> parseLineTokens(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (Character.isWhitespace(c) && !inQuotes) {
                if (sb.length() > 0) {
                    tokens.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            tokens.add(sb.toString());
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        String firstLine = scanner.nextLine().trim();
        if (firstLine.isEmpty()) {
            return;
        }
        int n = Integer.parseInt(firstLine);
        List<ExamQuestion> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            List<String> tokens = parseLineTokens(line);
            if (tokens.size() < 5) {
                continue;
            }
            String type = tokens.get(0);
            String text = tokens.get(1);
            String correct = tokens.get(2);
            String student = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            if (type.equalsIgnoreCase("MCQ")) {
                questions.add(new MultipleChoiceQuestion(text, correct, student, points));
            } else if (type.equalsIgnoreCase("TF")) {
                questions.add(new TrueFalseQuestion(text, correct, student, points));
            } else if (type.equalsIgnoreCase("ESSAY")) {
                questions.add(new EssayQuestion(text, correct, student, points));
            }
        }
        ExamGrader grader = new ExamGrader();
        grader.grade(questions);
        scanner.close();
    }
}
