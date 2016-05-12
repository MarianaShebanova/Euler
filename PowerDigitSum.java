import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int MAX = 10000;
    
    private static int[] countSum() {
        int[] sums = new int[MAX + 1];
        sums[0] = 1; 
        StringBuilder res = new StringBuilder().append(1);
        for (int i = 1; i <= MAX; i++) {
            StringBuilder temp = new StringBuilder();
            int r = 0;            
            for (int j = 0; j < res.length(); j++) {
                int sum = (res.charAt(j) - '0') * 2 + r;
                sums[i] += sum % 10;
                temp.append(sum % 10);
                r = sum / 10;
            }
            if (r != 0) {
                sums[i] += r;
                temp.append(r);
            }
            res = temp;
        }        
        return sums;
    }
    
    public static void main(String[] args) {
        int[] sum = countSum();        
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
           int n = sc.nextInt();
           System.out.println(sum[n]);
        }
    }
}
