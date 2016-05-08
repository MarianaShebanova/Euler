import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static final int MAX = 5000000;

	private static long update(long num, long[] a) {
		if (num == 1) {
			return 1;
		}
		if (num <= MAX && a[(int) num] != 0) {
			return a[(int) num];
		}
		long res = 0;
		if (num % 2 == 0) {
			res = update(num / 2, a) + 1;
		} else {
			res = update(3 * num + 1, a) + 1;
		}
		if (num <= MAX) {
			a[(int) num] = res;
		}
		return res;
	}

	public static void main(String[] args) {
		long[] a = new long[MAX + 1];
		a[1] = 1;
		for (int i = 2; i <= MAX; i++) {
			if (a[i] == 0) {
				update(i, a);
				int p = i;
				while (p * 2 <= MAX) {
					a[p * 2] = a[p] + 1;
					p = p * 2;
				}
			}
		}
		long[] max = new long[MAX + 1];
		for (int i = 1; i <= MAX; i++) {
			max[i] = a[(int) max[i - 1]] > a[i] ? max[i - 1] : i;
		}
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = sc.nextInt();
			System.out.println(max[n]);
		}
		sc.close();
	}
}
