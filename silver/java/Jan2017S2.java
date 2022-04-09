import java.util.*;
import java.io.*;

public class Jan2017S2 {
    public static void main(String[] args) throws IOException {
        String problemName = "hps";
        Scanner in = new Scanner(new BufferedReader(new FileReader(problemName + ".in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));//*/
        /*Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);//*/
        int n = in.nextInt(); in.nextLine();
        int[] moves = new int[n];
        for (int i = 0; i < n; i++) {
            char c = in.nextLine().charAt(0);
            if (c == 'P') moves[i] = 1;
            else if (c == 'S') moves[i] = 2;
        }
        int[][] pre = new int[n + 1][3], suf = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            int p = moves[i - 1], s = moves[n - i];
            for (int j = 0; j < 3; j++) {
                pre[i][j] = pre[i - 1][j];
                suf[n - i][j] = suf[n - i + 1][j];
            }
            pre[i][p]++;
            suf[n - i][s]++;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    ans = Math.max(ans, pre[i][j] + suf[i][k]);
                }
            }
        }
        out.println(ans);
        in.close(); out.close();
    }
}
