import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static final int MAX = 500;
	private static final long MOD = 1000000007;

	public static void main(String[] args) {
		long[][] a = new long[MAX + 1][MAX + 1];
		a[0][0] = 1;
		for (int i = 0; i <= MAX; i++) {
			for (int j = 0; j <= MAX; j++) {
				if (i - 1 >= 0) {
					a[i][j] = (a[i][j] + a[i - 1][j]) % MOD;
				}
				if (j - 1 >= 0) {
					a[i][j] = (a[i][j] + a[i][j - 1]) % MOD;
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(a[n][m]);
		}
		sc.close();
	}
}
