import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*String problemName = "perimeter";
        Scanner in = new Scanner(new BufferedReader(new FileReader(problemName + ".in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));//*/
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);//*/
        int n = in.nextInt();
        in.nextLine();
        field = new int[n + 2][n + 2];
        flooded = new boolean[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            field[0][i] = 0; field[n + 1][i] = 0;
            field[i][0] = 0; field[i][n + 1] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            in.useDelimiter("");
            for (int j = 1; j < n + 1; j++) {
                switch (in.next().charAt(0)) {
                    case '#': field[i][j] = 1; break;
                    case '.': field[i][j] = 0;
                }
            }
            in.nextLine();
        }
        int[] best = {-1, -1};
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!flooded[i][j]) {
                    int[] cur = ff(i, j, new int[] {0, 0});
                    if (cur[0] == best[0]) {
                        best = (cur[1] < best[1]) ? cur : best;
                    } else if (cur[0] > best[0]) {
                        best = cur;
                    }
                }
            }
        }
        /*for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                out.print(field[i][j] + " ");
            }
            out.println();
        }*/
        out.println(best[0] + " " + best[1]);
        in.close(); out.close();
    }
    
    static int[][] field;
    static boolean[][] flooded;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    
    public static int[] ff(int x, int y, int[] cur) {
        if (flooded[x][y] || field[x][y] == 0) return cur;
        flooded[x][y] = true;
        cur[0]++;
        for (int i = 0; i < 4; i++) {
            if (!flooded[x + dx[i]][y + dy[i]]) {
                cur = ff(x + dx[i], y + dy[i], cur);
            }
            if (field[x + dx[i]][y + dy[i]] == 0) cur[1]++;
        }
        return cur; //area & perim
    }
}
