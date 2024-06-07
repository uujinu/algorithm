package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_12851_숨바꼭질2 {
    // 반례: https://www.acmicpc.net/board/view/56215

    /*

    // 첫 번째 푼 풀이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        // n: 0~100000, k: 0~100000
        // 순간이동: 2*X
        // 동생 찾는 가장 빠른 시간이 몇 초 후인지, 몇 가지인지 구하기
        int time = 0, count = 0;
        int[][] dp = new int[100003][2];

        // 짝수의 경우 : 이전, 이후, 절반 인덱스 비교. 나보다 1작은 애가 정답임. 작은애가 여러개있으면 걔네 더해줌.
        // 홀수의 경우 : 이전, 이후 인덱스 비교.
        //
        // 0   1    2    3    4   5   6   7   8   9   10   11   12   13   14    15    16    17    18    19    20     21    22
        // 5   4    3    2    1   0   1   2   2   2    1    2    2    3    3    4      3     4     3     3     2      3     3
        // 1   1    1    1    1   1   1   1   1   1    1    1    1    1    1    2      1     2     1     1     1      1     ?
        //
        //   5 10 9 18 17    (5,17)
        //   5 4 8 16 17  =>  2가지
        ///

        if (n >= k) {
            time = n - k;
            count = 1;
        } else {
            boolean flag = false;

            for (int i = 0; i <= n; i++) { // n 이전 부분 채우기
                dp[i][0] = n - i;
                dp[i][1] = 1;
            }

            for (int i = n + 1; i <= k + 2; i++) { // n 다음 부분부터 채우기
                if (i % 2 == 0) { // 짝수인 경우
                    dp[i][0] = Math.min(dp[i / 2][0], dp[i - 1][0]) + 1;

                    // 홀수부분
                    if (dp[i - 1][0] > dp[i][0] + 1) {
                        dp[i - 1][0] = dp[i][0] + 1;
                    }
                } else { // 홀수인 경우
                    dp[i][0] = dp[i - 1][0] + 1;
                }
            }

            // 경우의 수
            for (int i = n + 1; i <= k + 1; i++) {
                if (i % 2 == 0) { // 짝수인 경우
                    // 절반, 전, 후의 숫자 비교 후 작은 쪽으로 함
                    if (dp[i / 2][0] + 1 == dp[i][0]) dp[i][1] = dp[i / 2][1];
                    if (dp[i - 1][0] + 1 == dp[i][0]) dp[i][1] += dp[i - 1][1];
                    if (dp[i + 1][0] + 1 == dp[i][0]) dp[i][1] += dp[i + 1][1];
                    if (flag) {
                        // 이전 홀수부분 처리
                        // 만약 둘이 더해야 되면
                        if (dp[i - 2][0] + 1 == dp[i - 1][0] && dp[i - 2][0] == dp[i][0]) {
                            dp[i - 1][1] = dp[i - 2][1] + dp[i][1];
                        } else if (dp[i - 2][0] + 1 == dp[i - 1][0] && dp[i][0] + 1 != dp[i - 1][0]) {
                            dp[i - 1][1] = dp[i - 2][1];
                        } else if (dp[i - 2][0] + 1 != dp[i - 1][0] && dp[i][0] + 1 == dp[i - 1][0]) {
                            dp[i - 1][1] = dp[i][1];
                        }
                        flag = false;
                    }
                } else { // 홀수인 경우
                    // 앞뒤 경우의 수 더해야하는 경우
                    if (dp[i - 1][0] + 1 == dp[i][0] && dp[i - 1][0] == dp[i + 1][0]) {
                        flag = true;
                    } else {
                        if (dp[i - 1][0] + 1 == dp[i][0] && dp[i + 1][0] + 1 != dp[i][0]) dp[i][1] = dp[i - 1][1];
                        else flag = true; // 얘도 다음에 처리함
                    }
                }
            }

            for (int i = 0; i <= k + 1; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }

            time = dp[k][0];
            count = dp[k][1];
        }

        System.out.println(time);
        System.out.println(count);
    }
     */

    // 복습하면서 푼 것
    public static void main(String[] args) throws IOException {

        /**
         * 동생을 찾는 가장 빠른 시간, 가장 빠른 시간에 찾는 방법이 몇 가지인가
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        if (k <= n) { // 동생이 왼쪽에 있다면 x-1로 이동하는 방법뿐
            System.out.println(String.valueOf(n - k) + "\n1");
        } else { // 왼쪽에 있는 곳은 x-1로 이동하는 1가지뿐
            int[][] m = new int[k + 3][2]; // 0열: 시간, 1열: 방법

            for (int i = 0; i <= n; i++) { // n자리까지 초기화
                m[i][0] = n - i; // 시간
                m[i][1] = 1;     // 방법
            }

            // 1. 최소 시간 찾기
            for (int i = n + 1; i < m.length; i++) { // n+1자리부터 끝까지
                m[i][0] = m[i - 1][0] + 1; // 현재칸 = 이전 칸에서의 시간+1
                if (i % 2 == 0) { // 짝수일 경우 /2인 곳에서의 시간+1
                    m[i][0] = Math.min(m[i][0], m[i / 2][0] + 1);
                    m[i - 1][0] = Math.min(m[i - 1][0], m[i][0] + 1);
                }
            }

            // 2. 방법의 수 찾기
            // 짝수인 경우 인덱스/2와 인덱스-1, 인덱스+1인 곳 비교
            // 홀수인 경우 인덱스-1, 인덱스+1인 곳 비교

            boolean flag = false; // 이전 경우의 수 처리해야하는 경우

            for (int i = n + 1; i <= k + 1; i++) { // n+1부터 k+1까지
                // 만약 짝수라면 /2에서 오는 경우
                if (i % 2 == 0) {
                    if (m[i / 2][0] + 1 == m[i][0]) m[i][1] += m[i / 2][1];
                }

                // 이전에 오는 경우
                if (m[i - 1][0] + 1 == m[i][0]) m[i][1] += m[i - 1][1];

                if (flag) { // 이전 것 처리
                    m[i - 1][1] += m[i][1];
                }

                // 다음에서 오는 경우
                if (m[i + 1][0] + 1 == m[i][0]) flag = true;
                else flag = false;

            }

            System.out.println(String.valueOf(m[k][0]) + "\n" + String.valueOf(m[k][1]));
        }
    }
}
