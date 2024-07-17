import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++)
            ar[i] = sc.nextInt();

        helper(0, ar, new ArrayList<>());
        System.out.println();
        sc.close();
    }

    public static void helper(int i, int[] ar, ArrayList<Integer> res) {

        if (i == ar.length) {

            if (res.size() == 0)
                return;

            for (int e : res)
                System.out.print(e + ",");
            
            System.out.println();
            return;
        }

        res.add(ar[i]);
        helper(i + 1, ar, res);

        res.remove(res.size() - 1);
        helper(i + 1, ar, res);

    }
}
