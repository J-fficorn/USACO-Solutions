import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String problemName = "diamond";
        Scanner in = new Scanner(problemName + ".in");
        PrintWriter out = new PrintWriter(problemName + ".out");
        int n = in.nextInt(), k = in.nextInt();
        int[] gems = new int[n];
        for (int i = 0; i < n; i++) gems[i] = in.nextInt();
        Arrays.sort(gems);
        int l = 0, case1 = 0, case2 = 0;
        List<Integer> toRemove = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<Integer>(i);
            l = i + 1;
            while (l < n && gems[l] - gems[i] <= k) {
                temp.add(l);
                l++;
            }
            if (l - i > case1) {
                toRemove = new ArrayList<Integer>(temp);
                case1 = l - i;
            }
        }
        List<Integer> leftover = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < n; i++) {
            if (j < toRemove.size() && i == toRemove.get(j)) { j++; continue; }
            leftover.add(gems[i]);
        }
        int newN = leftover.size();
        gems = new int[newN];
        for (int i = 0; i < newN; i++) gems[i] = leftover.get(i); //convert to array
        for (int i = 0; i < newN; i++) {
            l = i + 1;
            while (l < newN && gems[l] - gems[i] <= k) l++;
            case2 = Math.max(case2, l - i);
        }
        out.println(case1 + case2);
        in.close(); out.close();
    }
}
