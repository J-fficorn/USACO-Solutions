import java.util.*;
import java.io.*;

public class Dec2016S2 {
    public static void main(String[] args) throws IOException {
        String problemName = "citystate";
        /*Scanner in = new Scanner(new BufferedReader(new FileReader(problemName + ".in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));//*/
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);//*/
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s1 = in.next().substring(0, 2).toUpperCase() , s2 = in.next(), s = s1 + s2;
            if (!s1.equals(s2)) {
                if (!IDs.containsKey(s)) IDs.put(s, 0L);
                IDs.put(s, IDs.get(s) + 1);
            }
            in.nextLine();
        }
        long ans = 0L;
        for (String s : IDs.keySet()) {
            String rev = s.substring(2) + s.substring(0, 2);
            if (IDs.containsKey(rev)) ans += IDs.get(s) * IDs.get(rev);
        }
        out.println(ans / 2);
        in.close(); out.close();
    }
    
    static int n;
    static Map<String, Long> IDs = new HashMap<String, Long>();
}
