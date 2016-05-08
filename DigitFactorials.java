import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static final int DIGITS = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] factorials = new int[DIGITS];
		factorials[0] = 1;
		for (int i = 1; i < DIGITS; i++) {
			factorials[i] = factorials[i - 1] * i;
		}
		int n = sc.nextInt();
		long res = 0;
		for (int i = 10; i < n; i++) {
			int temp = i;
			long sum = 0;
			while (temp > 0) {
				sum = sum + factorials[temp % 10];
				temp /= 10;
			}
			if (sum % i == 0) {
				res = res + i;
			}
		}
		System.out.println(res);
		sc.close();
	}
}
