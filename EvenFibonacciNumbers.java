import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static long[] buildFib() {
		long[] res = new long[84];
		res[0] = 1;
		res[1] = 2;
		for (int i = 2; i < 84; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res;
	}

	public static void main(String[] args) {
		long[] fibonacci = buildFib();
		long[][] sum = new long[84][2];

		for (int i = 0; i < 84; i++) {
			sum[i][0] = fibonacci[i];
			if (fibonacci[i] % 2 == 0) {
				sum[i][1] = sum[i - 1][1] + fibonacci[i];
			} else {
				if (i - 1 >= 0) {
					sum[i][1] = sum[i - 1][1];
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			long n = sc.nextLong();
			long res = 0l;
			for (int i = 0; i < 84; i++) {
				if (sum[i][0] > n) {
					break;
				}
				res = sum[i][1];
			}
			System.out.println(res);
		}
	}
}
