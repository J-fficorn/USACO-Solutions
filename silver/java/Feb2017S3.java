import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String problemName = "countcross";
        /*Scanner in = new Scanner(new BufferedReader(new FileReader(problemName + ".in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));//*/
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);//*/
        n = in.nextInt(); k = in.nextInt(); r = in.nextInt(); ans = 0;
        cows = new int[k][2]; roads = new int[r][4]; // x y from x y to
        boolean[][] flooded = new boolean[n][n];
        for (int i = 0; i < r; i++) roads[i] = new int[] {in.nextInt() - 1, in.nextInt() - 1, in.nextInt() - 1, in.nextInt() - 1};
        for (int i = 0; i < k; i++) cows[i] = new int[] {in.nextInt() - 1, in.nextInt() - 1};
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (!ff(cows[i][0], cows[i][1], cows[j][0], cows[j][1], flooded.clone())) ans++;
            }
        }
        out.println(ans);
        in.close(); out.close();
    }
    
    static int n, k, r, ans;
    static int[][] roads, cows;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    
    public static boolean ff(int x, int y, int a, int b, boolean[][] flooded) {
        if (x == a && y == b) return true; //target
        boolean[][] copy = flooded.clone();
        copy[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i], nY = y + dy[i];
            if (valid(x, y, nX, nY) && !copy[nX][nY]) {
                if (ff(nX, nY, a, b, copy)) return true;
            }
        }
        return false;
    }
    
    public static boolean valid(int x, int y, int a, int b) { //if x, y is within field and not blocked by road
        for (int[] road : roads) {
            if ((x == road[0] && y == road[1] && a == road[2] && b == road[3]) //road blocking
            || (a == road[0] && b == road[1] && x == road[2] && y == road[3])) {
                return false;
            }
        }
        return (!(a < 0 || a > n - 1|| b < 0 || b > n - 1));
    }
}
