import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextLine();
		}
		int r = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = s[0].length() - 1; i >= 0; i--) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += s[j].charAt(i) - '0';
			}
			sum += r;
			sb.append(sum % 10);
			r = sum / 10;
		}
		while (r != 0) {
			sb.append(r % 10);
			r = r / 10;
		}
		System.out.println(sb.reverse().substring(0, 10));
		sc.close();
	}
}
