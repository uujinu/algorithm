package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A_1874_스택 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> s = new ArrayDeque<>();

        int num = 1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (num <= a) {
                while (num <= a) {
                    s.push(num++);
                    sb.append('+').append('\n');
                }
                s.pop();
                sb.append('-').append('\n');
            } else {
                while (!s.isEmpty() && s.peek() > a) {
                    s.pop();
                    sb.append('-').append('\n');
                }
                if (s.isEmpty() || s.peek() != a) {
                    flag = false;
                    break;
                } else {
                    s.pop();
                    sb.append('-').append('\n');
                }
            }
        }
        if (flag && s.isEmpty())
            System.out.println(sb.deleteCharAt(sb.length() - 1));
        else System.out.println("NO");
    }
}
