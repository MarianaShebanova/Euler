import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int MAX = 999;
    private static final int MIN = 100;
    
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        for (int i = MIN; i <= MAX; i++) {
            for (int j = MIN; j <= MAX; j++) {
                int product = i * j;
                String s = product + "";
                if (s.equals(new StringBuilder(s).reverse().toString())) {
                    set.add(product);
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = sc.nextInt();
            int res = 0;
            for (Integer e : set) {
                if (e > n) {
                    break;
                }
                res = e;
            }
            System.out.println(res);
        }
    }
}
