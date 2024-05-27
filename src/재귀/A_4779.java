package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_4779 {

    static char[] c;
    static StringBuilder sb;

    static void sol(int l, int r) {
        if (r <= l || r - l == 1) return;
        int len = (r - l) / 3; // 공백 길이
        int mid = (l + r - 1) / 2; // 중간
        int newL = mid - len / 2, newR = mid + len / 2; // 공백 시작, 끝 인덱스
        for (int i = newL; i <= newR; i++) c[i] = ' '; // 공백으로 바꿈
        sol(l, newL);
        sol(newR + 1, r);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            c = new char[(int) Math.pow(3, n)];
            Arrays.fill(c, '-');

            sol(0, c.length);

            for (char x : c) sb.append(x);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
