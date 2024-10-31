import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah pertandingan : ");
        int numberOfMatches = scanner.nextInt();

        int[] teamScores = new int[numberOfMatches];
        int[] opponentScores = new int[numberOfMatches];

        for (int i = 0; i < numberOfMatches; i++) {
            System.out.print("Masukkan skor tim Kita ke-" + (i + 1) + ": ");
            teamScores[i] = scanner.nextInt();
        }

        for (int i = 0; i < numberOfMatches; i++) {
            System.out.print("Masukkan skor tim Lawan ke-" + (i + 1) + ": ");
            opponentScores[i] = scanner.nextInt();
        }

        int matchesWon = 0;
        int matchesLost = 0;
        int matchesDrawn = 0;

        for (int i = 0; i < numberOfMatches; i++) {
            if (teamScores[i] > opponentScores[i]) {
                matchesWon++;
            } else if (teamScores[i] < opponentScores[i]) {
                matchesLost++;
            } else {
                matchesDrawn++;
            }   
        }

        double winningPercentage = (double) matchesWon / numberOfMatches * 100;

        System.out.println("Jumlah Menang :" + matchesWon);
        System.out.println("Jumlah Kalah :" + matchesLost);
        System.out.println("Jumlah Draw :" + matchesDrawn);
        System.out.println("Persentase Kemenangan:" + winningPercentage);

    }
}
