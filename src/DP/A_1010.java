package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_1010 {

    /**
     * 메모이제이션을 이용한 조합 구하기
     * M개의 사이트에서 N개의 사이트 선택하는 경우의 수
     *
     *   mCn = m-1Cn-1 + m-1Cn
     *   표에서는 왼쪽위 + 위쪽 요소
     *
     *   m/n    0   1   2   3   4   ...   n
     *    0     0   0   0   0   0   ...
     *    1     1   1   0   0   0   ...
     *    2     1   2   1   0   0   ...
     *    3     1   3   3   1   0   ...
     *    4     1   4   6   4   1   ...
     *    5
     *
     */

    /*
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            int[][] comb = new int[m + 1][m + 1];
            boolean flag = true;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || i == j) {
                        comb[i][j] = 1;
                    } else {
                        comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                    }
                    if (i == m && j == n) { // mCn 찾았으면 종료
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }

            sb.append(comb[m][n]).append('\n');
        }
        System.out.println(sb.toString());
    }
     */

    public static void main(String[] args) throws IOException {

        /**
         * m개 중 n개 사이트를 선택하는 경우의 수: mCn
         * mCn = m-1Cn-1 + m-1Cn
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[m + 1][n + 1];
            dp[1][0] = 1;
            dp[1][1] = 1;

            for (int i = 2; i <= m; i++) {
                for (int j = 0; j <= i && j <= n; j++) {
                    if (j == 0 || i == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }
                }
            }
            sb.append(dp[m][n]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
