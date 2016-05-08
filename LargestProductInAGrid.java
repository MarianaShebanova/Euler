import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int N = 20;
    private static final int[] X = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};
    
    private static int max(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int res = 0;
        if (i + 3 < N) {
            res = Math.max(res, grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j]);
        }
        if (i - 3 >= 0) {
            res = Math.max(res, grid[i][j] * grid[i - 1][j] * grid[i - 2][j] * grid[i - 3][j]);
        }
        if (j + 3 < N) {
            res = Math.max(res, grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3]);
        }
        if (j - 3 >= 0) {
            res = Math.max(res, grid[i][j] * grid[i][j - 1] * grid[i][j - 2] * grid[i][j - 3]);
        }        
        if (i + 3 < N && j + 3 < N) {
            res = Math.max(res, grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3]);
        }
        if (i - 3 >= 0 && j - 3 >= 0) {
            res = Math.max(res, grid[i][j] * grid[i - 1][j - 1] * grid[i - 2][j - 2] * grid[i - 3][j - 3]);
        }
        if (i - 3 >= 0 && j + 3 < N) {
            res = Math.max(res, grid[i][j] * grid[i - 1][j + 1] * grid[i - 2][j + 2] * grid[i - 3][j + 3]);
        }
        if (j - 3 >= 0 && i + 3 < N) {
            res = Math.max(res, grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3]);
        }

        for (int k = 0; k < X.length; k++) {
            res = Math.max(res, max(grid, i + X[k], j + Y[k], visited));
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(max(grid, 0, 0, new boolean[N][N]));
        sc.close();
    }
}
