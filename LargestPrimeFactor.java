import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static long maxPrime(long n) {
		long i = 2;
		long res = n;
		while (i * i <= n) {
			while (res % i == 0) {
				res /= i;
			}
			if (res == 1) {
				res = i;
				break;
			}
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			long n = sc.nextLong();
			System.out.println(maxPrime(n));
		}
	}
}
