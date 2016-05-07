import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private static long lcmRec(long a, long b) {
		return a / gcd(a, b) * b;
	}

	private static long lcm(int n) {
		long res = 1;
		for (int i = 1; i <= n; i++) {
			res = lcmRec(res, i);
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = sc.nextInt();
			System.out.println(lcm(n));
		}
	}
}
