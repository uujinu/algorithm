package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A_3986_스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        while (n-- > 0) {
            char[] c = br.readLine().toCharArray();
            Stack<Character> s = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < c.length; i++) {
                if (!s.isEmpty() && s.peek() == c[i]) { // 이어진다.
                    flag = true;
                    s.pop();
                } else {
                    flag = false;
                    s.push(c[i]);
                }
            }
            if (flag && s.isEmpty()) res++;
        }
        System.out.println(res);
    }
}
