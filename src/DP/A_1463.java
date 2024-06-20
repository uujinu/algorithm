package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_1463 {

    /**
     * X가
     * - 3으로 나누어 떨어지면 3으로 나눈다.
     * - 2로 나누어 떨어지면 2로 나눈다.
     * - 1을 뺀다.
     * 위 세가지 연산을 최소한으로 사용하여 X를 1로 만드는 방법의 수
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 3];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 2 == 0) min = Math.min(min, dp[i / 2]);
            if (i % 3 == 0) min = Math.min(min, dp[i / 3]);
            min = Math.min(min, dp[i - 1]);
            dp[i] = min + 1; // 셋 중 제일 작은 경우의 수 + 1
        }
        System.out.println(dp[n]);
    }
}
