import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int max = 0;
            for (int i = 0; i + k < n; i++) {
                int p = 1;
                for (int j = i; j < i + k; j++) {
                    p *= s.charAt(j) - '0';
                }
                max = Math.max(max, p);
            }
            System.out.println(max);
        }
    }
}
