import java.util.*;
import java.io.*;

public class USO2019S3 {
    public static void main(String[] args) throws IOException {
        String problemName = "fenceplan";
        Scanner in = new Scanner(new BufferedReader(new FileReader(problemName + ".in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));//*/
        /*Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);//*/
        int n = in.nextInt(), m = in.nextInt();
        x = new int[n]; y = new int[n];
        adj = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt(); y[i] = in.nextInt();
            adj[i] = new ArrayList<Integer>();
        }
        /*for (int i = 0; i < n; i++) {
            out.println(x[i] + " " + y[i]);
        }*/
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        int min = (int) 2e9;
        for (int i = 0; i < n; i++) {
            int[] dim = { (int) 2e9, 0, (int) 2e9, 0 };
            dim = dfs(i, dim);
            int size = halfPerim(dim);
            if (size < min) {
                min = size;
            }
        }
        out.println(min * 2);
        in.close(); out.close();
    }
    static ArrayList<Integer>[] adj;
    static int[] x, y;
    static boolean[] visited;

    public static int[] dfs(int i, int[] dim) { //x-min, x-max, y-min, y-max
        if (visited[i]) { return dim; }
        visited[i] = true;
        dim[0] = Math.min(dim[0], x[i]); dim[1] = Math.max(dim[1], x[i]);
        dim[2] = Math.min(dim[2], y[i]); dim[3] = Math.max(dim[3], y[i]); //change dimensions
        for (int a : adj[i]) {
            dim = dfs(a, dim);
        }
        return dim;
    }

    public static int halfPerim(int[] dim) {
        return dim[1] - dim[0] + dim[3] - dim[2];
    }
}
