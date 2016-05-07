import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int MAX = 1000000;
    public static void main(String[] args) {
        boolean[] seave = new boolean[MAX];
        seave[0] = true;
        seave[1] = true;
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i < MAX; i++) {
            if (!seave[i]) {
                prime.add(i);
                if ((long)i * i < (long)MAX)
                for (int j = i * i; j < MAX; j += i) {
                    seave[j] = true;
                }
            }
        }
        
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = sc.nextInt();
            System.out.println(prime.get(n - 1));
        }
    }
}
