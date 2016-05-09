import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static String convert(int num, int k) {
        return Integer.toString(num, k);
    }
    
    private static boolean isPalindromic (String num) {
        String reverseNum = new StringBuilder().append(num).reverse().toString();
        return num.equals(reverseNum);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (isPalindromic("" + i) && isPalindromic(convert(i, k))) {
                    res += i;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
