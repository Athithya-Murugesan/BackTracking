import java.io.*;
import java.util.*;
import java.lang.*;

class Main{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
    }
}
class Solution{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> sol = new LinkedList<>();
    static int[][] visited;
    static int len;
    static boolean isSafe(int row, int col)
    {
        int i, j;
        int[][] board = visited;
        /* Check this row on left side */
        for (i = 0; i < row; i++)
            if (visited[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (visited[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j <len && i >= 0; i--, j++)
            if (visited[i][j] == 1)
                return false;

        return true;
    }

    static void solveNQ(int x,int n){
        if(n == 0){
            res.add(new ArrayList<>(sol));

        }
        for(int i = 0 ; i < len ; i++){
            if(isSafe(x,i)){
                visited[x][i] = 1;
                sol.add(i+1);
                solveNQ(x+1,n-1);
                sol.removeLast();
                visited[x][i] = 0;
            }
        }
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        visited = new int[n][n];
        len = n;
        //res.clear();
        //sol.clear();
        solveNQ(0,n);
        return res;
    }
}



// //Recursion tree
// solveNQ(0, 4) - Start at row 0
// |
// |-- solveNQ(1, 3) - Place queen at (0, 0)
// |   |
// |   |-- solveNQ(2, 2) - Place queen at (1, 2)
// |   |   |
// |   |   |-- solveNQ(3, 1) - Place queen at (2, 1)
// |   |   |   |
// |   |   |   |-- solveNQ(4, 0) - Place queen at (3, 3), Solution found: [1, 3, 2, 4]
// |   |   |
// |   |   |-- Backtrack
// |   |
// |   |-- Backtrack
// |
// |-- solveNQ(1, 3) - Place queen at (0, 1)
// |   |
// |   |-- solveNQ(2, 2) - Place queen at (1, 3)
// |   |   |
// |   |   |-- solveNQ(3, 1) - Place queen at (2, 0)
// |   |   |   |
// |   |   |   |-- solveNQ(4, 0) - Place queen at (3, 2), Solution found: [2, 4, 1, 3]
// |   |   |
// |   |   |-- Backtrack
// |   |
// |   |-- Backtrack
// |
// |-- solveNQ(1, 3) - Place queen at (0, 2)
// |
// |-- solveNQ(1, 3) - Place queen at (0, 3)
