package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _4기_A_2309 {
    static int[] h;
    static boolean[] v;
    static StringBuilder sb;
    static boolean flag = false;

    static void sol(int depth, int sum, int idx) {
        if (flag) return;
        if (depth == 7) {
            if (sum == 100) {
                flag = true;
                for (int i = 0; i < 9; i++) {
                    if (v[i]) {
                        sb.append(h[i]).append('\n');
                    }
                }
            }
            return;
        }
        if (idx >= 9) return;

        for (int i = idx; i < 9; i++) {
            if (!v[i]) {
                v[i] = true;
                sol(depth + 1, sum + h[i], i + 1);
                v[i] = false;
                sol(depth, sum, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 합이 100
        // 키 오름차순 출력
        h = new int[9];
        v = new boolean[9];
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(h);
        for (int i = 0; i < 9; i++) {
            v[i] = true;
            sol(1, h[i], i + 1);
            v[i] = false;
            sol(0, 0, i + 1);
        }
        System.out.println(sb.toString());
    }
}
