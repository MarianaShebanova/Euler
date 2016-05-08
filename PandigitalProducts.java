import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static final int MAX = 9999;

	private static boolean isPandigital(String numbers, int n) {
		int[] freq = new int[n + 1];
		for (int i = 0; i < numbers.length(); i++) {
			int digit = numbers.charAt(i) - '0';
			if (digit > n) {
				return false;
			}
			freq[digit]++;
		}
		for (int i = 1; i < freq.length; i++) {
			if (freq[i] == 0 || freq[i] > 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Set<Integer> products = new HashSet<>();
		for (int i = 1; i <= MAX; i++) {
			for (int j = 1; j <= MAX; j++) {
				int product = i * j;
				String numbers = ("" + i + j + product);
				if (numbers.length() > n) {
					break;
				}
				if (isPandigital(numbers, n)) {
					products.add(product);
				}
			}
		}
		int sum = 0;
		for (Integer p : products) {
			sum += p;
		}
		System.out.println(sum);
		sc.close();
	}
}
