import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int MAX = 50000;

    public static void main(String[] args) {
        int[] div = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                div[j]++;
            }
        }   
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = sc.nextInt();
            int i = 1;
            boolean res = true;
            int p = 1;
            do {
                if (res) {
                    p = div[i] * div[(i + 1) / 2];
                    res = false;
                } else {
                    p = div[i / 2] * div[i + 1];
                    res = true;
                }
                i++;
            } while (p <= n);
            System.out.println((i - 1) * i / 2);
        }
        sc.close();
    }
}
