import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = sc.nextInt();
            sc.nextLine();
            int[][] triangle = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] temp = sc.nextLine().split(" ");
                for (int j = 0; j < temp.length; j++) {
                    triangle[i][j] = Integer.parseInt(temp[j]);
                }
            } 
            
            int[][] maxSum = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                   maxSum[i][j] = triangle[i][j];
                   if (i - 1 >= 0 && j - 1 >= 0) {
                       maxSum[i][j] += Math.max(maxSum[i - 1][j], maxSum[i - 1][j - 1]);
                   } else if (i - 1 >= 0){
                       maxSum[i][j] += maxSum[i - 1][j];                       
                   }                     
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(maxSum[n - 1][i], max);
            }
            System.out.println(max);
        }
    }
}
