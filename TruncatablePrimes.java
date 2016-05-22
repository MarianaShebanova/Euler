import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TruncatablePrimes {
    private static final int MAX = 1000001;

    private static Set<Integer> getPrimes() {
        boolean[] noprimes = new boolean[MAX];
        noprimes[0] = true;
        noprimes[1] = true;
        for (int i = 2; i < MAX; i++) {
            if (!noprimes[i]) {
                if ((long) i * i < MAX) {
                    for (int j = i * i; j < MAX; j += i) {
                        noprimes[j] = true;
                    }
                }
            }
        }
        Set<Integer> primes = new HashSet<>();
        for (int i = 0; i < MAX; i++) {
            if (!noprimes[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean trancatablePrimes(int number, Set<Integer> primes) {
        String s = Integer.toString(number);
        // left
        for (int i = 0; i < s.length(); i++) {
            if (!primes.contains(Integer.parseInt(s.substring(i)))) {
                return false;
            }                
        }
        //right
        for (int i = 0; i < s.length(); i++) {
            if (!primes.contains(Integer.parseInt(s.substring(0, s.length() - i)))) {
                return false;
            }                            
        }
        return true;
    }
    
    public static void main(String[] args) {
        Set<Integer> primes = getPrimes();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 10; i <= n; i++) {
            if (trancatablePrimes(i, primes)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
