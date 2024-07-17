import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] s = sc.next().toCharArray();
        Arrays.sort(s);

        boolean[] visited = new boolean[s.length];

        helper(s, "", visited);
    }

    public static void helper(char[] s, String curr, boolean[] visited) {

        if (curr.length() == s.length) {

            System.out.println(curr);
            return;
        }

        for (int i = 0; i < s.length; i++) {

            if (visited[i])
                continue;

            visited[i] = true;
            String str = curr + s[i];

            helper(s, str, visited);

            visited[i] = false;
        }
    }
}

