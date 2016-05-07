import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static final int MAX = 1000001;

	public static void main(String[] args) {
		boolean[] prime = new boolean[MAX];
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i < MAX; i++) {
			if (!prime[i]) {
				if ((long) i * i < MAX) {
					for (int j = i * i; j < MAX; j += i) {
						prime[j] = true;
					}
				}
			}
		}
		long[] sum = new long[MAX];
		for (int i = 1; i < MAX; i++) {
			sum[i] += sum[i - 1];
			if (!prime[i]) {
				sum[i] += i;
			}
		}
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = sc.nextInt();
			System.out.println(sum[n]);
		}
	}
}
