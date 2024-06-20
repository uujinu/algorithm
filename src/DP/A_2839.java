package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_2839 {

    /**
     * 3, 5킬로그램 봉지
     * 최대한 적은 봉지로 n킬로그램 배달
     * dp[n - 3]일 때와 dp[n - 5]에서의 min값 비교하기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 8][2];
        // 킬로그램, 3/5킬로그램 봉지 개수
        dp[3] = new int[]{1, 0};
        dp[5] = new int[]{0, 1};
        dp[6] = new int[]{2, 0};
        dp[8] = new int[]{1, 1};
        dp[9] = new int[]{3, 0};
        dp[10] = new int[]{0, 2};
        if (n < 11) {
            if (dp[n][0] == 0 && dp[n][1] == 0) System.out.println(-1);
            else System.out.println(dp[n][0] + dp[n][1]);
        } else {
            for (int i = 11; i <= n; i++) {
                int a1 = dp[i - 3][0], a2 = dp[i - 3][1]; // 3킬로 모자랄 때
                int b1 = dp[i - 5][0], b2 = dp[i - 5][1]; // 5킬로 모자랄 때
                int sumA = a1 + a2;
                int sumB = b1 + b2;
                if (sumA == 0 && sumB == 0) continue; // 둘 다 0이면 넘어감

                if (sumA <= sumB) {
                    if (sumA != 0) { // sumA가 0이 아니면
                        dp[i] = new int[]{a1 + 1, a2}; // 3키로 추가
                    } else dp[i] = new int[]{b1, b2 + 1}; // sumA가 0이면 sumB로
                } else {
                    if (sumB != 0) {
                        dp[i] = new int[]{b1, b2 + 1}; // 5키로 추가
                    } else dp[i] = new int[]{a1 + 1, a2}; // sumB가 0이면 3키로 추가
                }
            }
            int res = dp[n][0] + dp[n][1];
            System.out.println(res == 0 ? -1 : res);
        }
    }
}
