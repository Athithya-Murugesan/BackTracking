import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            int[][] sol = new int[n][n];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++)
                    grid[i][j] = sc.nextInt();
            }

            if (!helper(0, 0, grid, sol))
                System.out.println(-1);

            else {

                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++)
                        System.out.print(sol[i][j] + " ");

                    System.out.println();
                }
            }

        }
    }

    public static boolean helper(int i, int j, int[][] grid, int[][] sol) {

        int n = grid.length;

        if (i == n - 1 && j == n - 1) {

            sol[i][j] = 1;
            return true;
        }

        if (!isSafe(i, j, grid) || grid[i][j] == 0)
            return false;

        sol[i][j] = 1;

        for (int k = 1; k <= grid[i][j] && k < n; k++) {

            if (helper(i, j + k, grid, sol))
                return true;

            if (helper(i + k, j, grid, sol))
                return true;
        }

        sol[i][j] = 0;
        return false;
    }

    public static boolean isSafe(int x, int y, int[][] grid) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return false;

        return true;
    }
