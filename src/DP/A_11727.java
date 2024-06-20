package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_11727 {

    /**
     * n = 1일 때 ->  |                          (1가지)
     * n = 2일 때 ->  =, ||, ㅁ                  (3가지)
     * n = 3일 때 ->  =|, |||, ㅁ|,    |=, |ㅁ    (5가지)
     *               (  n=2에  | )   (n=1에 =,ㅁ)
     *
     * .... | 인 dp[i - 1]의 경우
     * .... = 인 dp[i - 2]의 경우
     * .... ㅁ 인 dp[i - 2]의 경우
     *
     * dp[i] = dp[i - 1] + 2 * dp[i - 2]
     *
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        System.out.println(dp[n - 1]);
    }
}
