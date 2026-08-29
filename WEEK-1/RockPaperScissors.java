import java.util.Random;

public class RockPaperScissors {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void runSimulation(String[] playerMoves, int numRounds) {
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[][] roundHistory = new String[numRounds][4];

        System.out.println("=== Rock-Paper-Scissors Game Simulation (" + numRounds + " Rounds) ===");

        for (int i = 0; i < numRounds; i++) {
            String playerMove;
            if (playerMoves != null && i < playerMoves.length) {
                playerMove = playerMoves[i];
            } else {
                playerMove = MOVES[random.nextInt(MOVES.length)];
            }

            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            roundHistory[i][0] = String.valueOf(i + 1);
            roundHistory[i][1] = playerMove;
            roundHistory[i][2] = computerMove;
            roundHistory[i][3] = result;

            System.out.printf("Round %d - Player: %-8s Computer: %-8s => %s%n",
                    (i + 1), playerMove, computerMove, result);
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < numRounds; i++) {
            System.out.printf("%-8s | %-12s | %-14s | %-15s%n",
                    roundHistory[i][0], roundHistory[i][1], roundHistory[i][2], roundHistory[i][3]);
        }
        System.out.println("-------------------------------------------------------------");

        double winPercentage = (wins * 100.0) / numRounds;
        System.out.println("\nFinal Summary (after " + numRounds + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        String[] sampleMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        runSimulation(sampleMoves, 5);
    }
}
