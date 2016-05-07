import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static final int MAX = 3001;

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i < MAX; i++) {
			for (int j = i + 1; j < MAX; j++) {
				int k = i * i + j * j;
				int root = (int) Math.sqrt(k);
				if (k == root * root) {
					int key = i + j + root;
					Integer value = map.get(key);
					if (value == null) {
						map.put(key, i * j * root);
					} else {
						map.put(key, Math.max(value, i * j * root));
					}
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = sc.nextInt();
			Integer value = map.get(n);
			System.out.println(value == null ? -1 : value);
		}
	}
}
