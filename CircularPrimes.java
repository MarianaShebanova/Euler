import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static final int MAX = 1000001;

	private static boolean isCircularPrime(int prime, boolean[] primes) {
		if (!primes[prime]) {
			return false;
		}
		String primeS = "" + prime;
		for (int i = 1; i < primeS.length(); i++) {
			primeS = primeS.substring(1) + primeS.charAt(0);
			if (!primes[Integer.parseInt(primeS)]) {
				return false;
			}
		}
		return true;
	}

	private static boolean[] getEratosthenesSieve() {
		boolean[] primes = new boolean[MAX];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < MAX; i++) {
			if (primes[i]) {
				if ((long) i * i < MAX) {
					for (int j = i * i; j < MAX; j += i) {
						primes[j] = false;
					}
				}
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		boolean[] primes = getEratosthenesSieve();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long res = 0;
		for (int i = 2; i <= n; i++) {
			if (isCircularPrime(i, primes)) {
				res += i;
			}
		}
		System.out.println(res);
		sc.close();
	}
}
