import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
private static final String[] numbers19 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
                                           "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
                                           "Sixteen", "Seventeen", "Eighteen", "Nineteen"}; 
    private static final String[] dec = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
                                         "Eighty","Ninety", "Hundred"};    
    private static final String[] mil = {"", "Thousand", "Million", "Billion"};    
    private static String inWords(long n) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (n > 0) {
            list.add(mil[i]);
            int num = (int)(n % 1000);
            boolean add = false;
            if (num % 100 < 20 && num % 100 > 0) {
                list.add(numbers19[num % 100]);
                add = true;
            } else if (num % 100 != 0 ){
                add = true;
                list.add(numbers19[num % 10]);
                list.add(dec[(num / 10) % 10]);
            } 
            
            if (num / 100 > 0) {
                add = true;
                list.add("Hundred");
                list.add(numbers19[num / 100]);
            }   
            if (!add) {
                list.remove(list.size() - 1);
            }
            n = n / 1000;
            i++;            
        }
        StringBuilder res = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            if (!list.get(j).isEmpty())
            res.append(list.get(j) + " ");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            long n = sc.nextLong();
            System.out.println(inWords(n));
        }
    }
}
