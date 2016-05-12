import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int sum(int n) {
       BigInteger p = new BigInteger("1");
       for (int i = 1; i <= n; i++) {
    	   p = p.multiply(new BigInteger("" + i));
       }
       String s = p.toString();
       int sum = 0;
       for (int i = 0 ; i < s.length(); i++) {
           sum += s.charAt(i) - '0';
       } 
       return sum; 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = sc.nextInt();
            System.out.println(sum(n));
        }
    }
}
