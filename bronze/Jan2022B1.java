import java.util.*;
import java.io.*;

public class Jan2022B1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        char[][] ans = new char[3][3];
        char[][] guess = new char[3][3];
        boolean[][] correct = new boolean[3][3];
        boolean[][] guessed = new boolean[3][3];
        int c = 0, g = 0;
        for (int i = 0; i < 3; i++) {
            in.useDelimiter("");
            for (int j = 0; j < 3; j++) {
                ans[i][j] = in.next().charAt(0);
            }
            in.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            in.useDelimiter("");
            for (int j = 0; j < 3; j++) {
                guess[i][j] = in.next().charAt(0);
            }
            in.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guess[i][j] == ans[i][j]) { correct[i][j] = true; c++; }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (correct[i][j]) { continue; }
                outer: for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (ans[i][j] == guess[k][l] && !guessed[k][l] && !correct[k][l]) {
                            guessed[k][l] = true;
                            g++;
                            break outer;
                        }
                    }
                }
            }
        }
        out.println(c + "\n" + g);
        in.close(); out.close();
    }
}
