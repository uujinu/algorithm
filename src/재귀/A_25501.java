package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_25501 {
    static String s;
    static int depth;

    static int isPalindrome(int l, int r) {
        depth++;
        if (l >= r) return 1;
        if (s.charAt(l) == s.charAt(r)) {
            return isPalindrome(l + 1, r - 1);
        } else return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            depth = 0;
            s = br.readLine();
            sb.append(isPalindrome(0, s.length() - 1)).append(" ").append(depth).append('\n');
        }
        System.out.println(sb.toString());
    }
}
