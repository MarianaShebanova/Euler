import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PandigitalMultiples {
    private static boolean kPandigital(int number, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (sb.length() < k) {
            sb.append(number * i);            
            i++;
        }
        if (sb.length() > k) {
            return false;
        }
        int[] freq = new int[k + 1];
        for (int j = 0; j < sb.length(); j++) {
            int index = sb.charAt(j) - '0';
            if (index < 1 || index > k) {
                return false;
            }
            freq[index]++;
            if (freq[index] > 1) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 2; i < n; i++) {
            if (kPandigital(i, k)) {
                System.out.println(i);
            }
        }
    }
}
