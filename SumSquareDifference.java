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
            long n = sc.nextLong();
            System.out.println(n * n * (n + 1) * (n + 1) / 4 - (n * (n + 1) * (2 * n + 1)) / 6);
        }
    }
}
