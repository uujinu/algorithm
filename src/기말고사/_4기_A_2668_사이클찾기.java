package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4기_A_2668_사이클찾기 {

    /**
     * 세로 두줄, 가로 N개 표
     * 정수를 최대로 많이 뽑는 방법찾기
     *
     *     1  2  3  4  5  6  7
     *     3  1  1  5  5  4  6
     *
     *     arr[i] -> arr[arr[i]] 이런 식으로 뽑힌 정수를 인덱스로 하는 숫자를 찾기
     *     처음 시작한 숫자와 같은 숫자가 나오면 사이클 완성
     */

    static int n, max = 0;
    static int[] a;
    static boolean[] v, s, r;

    static void sol(int start) {
        s = new boolean[n + 1];
        int curr = start; // 현재
        int next = a[curr]; // 다음
        while (!s[curr]) {
            s[curr] = true;
            curr = next;
            next = a[curr];
        }
        if (start == curr) { // 사이클
            for (int i = 1; i <= n; i++) {
                if (s[i]) {
                    if (!r[i]) {
                        max++;
                        r[i] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        v = new boolean[n + 1];
        r = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (i == a[i]) {
                max++;
                r[i] = true;
            }
            if (!v[a[i]]) v[a[i]] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (v[i]) sol(i);
        }

        sb.append(max).append('\n');
        for (int i = 1; i <= n; i++) {
            if (r[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
