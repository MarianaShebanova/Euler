
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
            long div = n % 5 == 0 ? (n - 1) / 5 : n / 5;
            long sum = 5 * div * (div + 1) / 2;
            div = n % 3 == 0 ? (n - 1) / 3 : n / 3;
            sum += 3 * div * (div + 1) / 2;
            div = n % 15 == 0 ? (n - 1) / 15 : n / 15;
            sum -= 15 * div * (div + 1) / 2;
            System.out.println(sum);
        }
    }
}
