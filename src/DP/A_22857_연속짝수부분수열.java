package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_22857_연속짝수부분수열 {

    /**
     * 수열 S에서 원소를 최대 K번 삭제한 후
     * 남은 수열에서 짝수로 이루어진 연속한 수열의 최대 길이 구하기
     *
     *    k\arr  1 2 3 4 5 6 7 8  => 3
     *     0     0 1 0 1 0 1 0 1
     *     1     0 1 2 2 2 2 2 2
     *     2     0 1 2 2 3 3 3 3
     *
     *    k\arr  1 2 2 3 4 5 6 8 8  => 6
     *     0     0 1 2 0 1 0 1 2 3
     *     1     0 1 2 3 3 2 2 3 4
     *     2     0 1 2 3 3 4 4 5 6
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(a -> a % 2).toArray();

        // DP 풀이
        if (arr.length == 1) {
            System.out.println(arr[0] == 0 ? 1 : 0);
        } else {
            int max = 0;
            int[][] dp = new int[k + 1][n]; // 0개 ~ k개 제거
            dp[0][0] = arr[0] == 0 ? 1 : 0;
            max = Math.max(dp[0][0], max);

            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j] == 0) { // 짝수
                        if (i == 0) { // k = 0인 경우
                            if (j == 0) dp[i][j] = 1; // 배열 시작부분이면 짝수 1개
                            else if (arr[j - 1] == 1) dp[i][j] = 1; // 이전에 홀수이면 1개부터 시작
                            else dp[i][j] = dp[i][j - 1] + 1; // 이전에 짝수면 +1개
                        } else { // k != 0인 경우
                            if (j == 0) dp[i][j] = 1; // 배열 시작부분이면 짝수 1개
                            else if (arr[j - 1] == 0) dp[i][j] = dp[i][j - 1] + 1; // 이전에 짝수면 +1개
                            // 이전에 홀수면 값 그대로
                            else dp[i][j] = dp[i][j - 1];
                        }
                    } else { // 홀수
                        // k = 0이거나 배열 시작부분이면 짝수 0개
                        if (i == 0 || j == 0) dp[i][j] = 0;
                        else {
                            // 홀수는 k-1, n-1일 때의 값에 n+1이 짝수면 1을 더해준다.
                            dp[i][j] = dp[i - 1][j - 1]; // k-1, n-1 배열 값 넣어주고
                            // 만약 다음에 짝수가 나오면 +1
                            if (j + 1 < n && arr[j + 1] == 0) ++dp[i][j];
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            System.out.println(max);
        }


        // 투포인터 풀이
        /*
        int eStart = 0;
        while(eStart < n && arr[eStart] == 1) ++eStart;
        if (eStart == n) {
            System.out.println(0);
        } else {
            int l = eStart, r = l;
            int odd = 0, even = 1;
            int res = even;
            while (l <= r) {
                if (odd > k) {
                    if (arr[l] == 0) --even;
                    else --odd;
                    ++l;
                } else {
                    ++r;
                    if (r >= n) break;
                    if (arr[r] == 0) ++even;
                    else ++odd;
                    res = Math.max(res, even);
                }
            }
            System.out.println(res);
        }
        */

        /*
        // 296ms

        int[][] dp = new int[2][n];
        int eStart = -1;
        dp[0][0] = arr[0] == 0 ? 1 : 0;
        dp[1][0] = arr[0] == 1 ? 1 : 0;
        if (dp[0][0] == 1) eStart = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == 0) {
                if (eStart == -1) eStart = i;
                dp[0][i] = dp[0][i - 1] + 1;
                dp[1][i] = dp[1][i - 1];
            } else {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1] + 1;
            }
        }
//        System.out.println(Arrays.toString(dp[0]));
//        System.out.println(Arrays.toString(dp[1]));

        if (dp[0][n - 1] <= 1 || dp[1][n - 1] <= k) {
            System.out.println(dp[0][n - 1]);
        } else {
            int l = eStart, r = l + 1;
            int max = 1;

            if (r < n && arr[r] == 0) max = 2;
            int len = max;
            int oNum = max == 2 ? 0 : 1;
            while(l <= r && r < n) {
                System.out.println("(" + l + ", " + r + ")");
                if (oNum <= k) {
                    System.out.println("oNum: " + oNum + ": " + k + "보다 작음");
                    max = Math.max(len, max);
                    System.out.println("max: " + max);
                    if (r + 1 < n) {
                        if (arr[r + 1] == 0) ++len;
                        else ++oNum;
                    }
                    ++r;
                } else {
                    System.out.println("oNum: " + oNum + ": " + k + "보다 큼");

                    if (arr[l] == 0) --len;
                    else --oNum;
                    ++l;
                }
            }
            System.out.println(max);
        }
        */
    }
}
