import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static long getDayOfWeek(long year, int month) {
		int q = 1;
		int m = month;
		long k = year % 100;
		long j = year / 100;
		if (month == 1) {
			m = 13;
			k = (year - 1) % 100;
			j = (year - 1) / 100;
		}
		if (month == 2) {
			m = 14;
			k = (year - 1) % 100;
			j = (year - 1) / 100;
		}
		long res = (q + (13 * (m + 1) / 5) + k + k / 4 + j / 4 + 5 * j);
		while (res >= 7) {
			res %= 7;
		}
		return res;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			long year1 = sc.nextLong();
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			if (day1 > 1) {
				month1++;
			}
			long year2 = sc.nextLong();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			long count = 0;
			if (year1 == year2) {
				for (int month = month1; month <= month2; month++) {
					if (getDayOfWeek(year1, month) == 1) {
						count++;
					}
				}
			} else {
				for (int month = month1; month <= 12; month++) {
					if (getDayOfWeek(year1, month) == 1) {
						count++;
					}
				}
				year1++;
				for (long year = year1; year < year2; year++) {
					for (int month = 1; month <= 12; month++) {
						if (getDayOfWeek(year, month) == 1) {
							count++;
						}
					}
				}
				for (int month = 1; month <= month2; month++) {
					if (getDayOfWeek(year2, month) == 1) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
