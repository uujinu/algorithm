package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_9465 {

    /**
     * 점수 합 최대, 서로 변을 공유하지 않는 스티커 집합
     * https://www.youtube.com/watch?v=vIYF1-zkPas
     */

    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] s = new int[2][n];
            s[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            s[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 선택했는지, 안했는지
            // 0,1: 윗줄 선택,선택x / 2,3: 아랫줄 선택,선택x
            int[][] dp = new int[n][4];
            dp[0][0] = s[0][0];
            dp[0][1] = 0;
            dp[0][2] = s[1][0];
            dp[0][3] = 0;
            for (int i = 1; i < n; i++) {
                // 0,1 윗줄
                // 현재 선택
                // 이전의아랫줄선택+현재,이전의아랫줄미선택+현재,이전의윗줄미선택+현재
                dp[i][0] = Math.max(Math.max(dp[i - 1][2], dp[i - 1][3]), dp[i - 1][1]) + s[0][i];


                // 현재 미선택
                // 이전의윗줄선택,이전의윗줄미선택
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);

                // 2,3 아랫줄
                // 이전의윗줄선택+현재, 이전의윗줄미선택+현재, 이전의아랫줄미선택+현재
                dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]) + s[1][i];

                // 현재 미선택
                // 이전의아랫줄선택, 이전의아랫줄미선택
                dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            }

            int max = -1;
            for (int i = 0; i < 4; i++) {
                max = Math.max(max, dp[n - 1][i]);
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb.toString());
    }
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int max = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][][] dp = new int[2][n][2]; // 선택x, 선택o
            arr[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dp[0][0][1] = arr[0][0]; // 윗줄 처음 선택
            dp[1][0][1] = arr[1][0]; // 아랫줄 처음 선택

            for (int i = 1; i < n; i++) {
                // 윗줄 선택 x
                dp[0][i][0] = Math.max(dp[1][i - 1][1], dp[0][i - 1][1]);

                // 윗줄 선택 o
                dp[0][i][1] = Math.max(Math.max(dp[0][i - 1][0], dp[1][i - 1][0]), dp[1][i - 1][1]) + arr[0][i];

                // 아랫줄 선택 x
                dp[1][i][0] = Math.max(dp[0][i - 1][1], dp[1][i - 1][1]);

                // 아랫줄 선택 o
                dp[1][i][1] = Math.max(Math.max(dp[0][i - 1][0], dp[0][i - 1][1]), dp[0][i - 1][1]) + arr[1][i];
            }
            max = Math.max(dp[0][n - 1][0], dp[0][n - 1][1]);
            max = Math.max(max, Math.max(dp[1][n - 1][0], dp[1][n - 1][1]));
            sb.append(max).append('\n');
        }
        System.out.println(sb.toString());
    }
}
