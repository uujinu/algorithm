package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4기_A_10844_계단수 {

    /**
     * - 1자리수: 9개
     *   1 2 3 4 5 6 7 8 9
     *
     * - 2자리수: 17개
     *   10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98 => 17개
     *
     * - 특징
     *   - 뒤에 1일 경우 앞에 2만 올 수 있음
     *   - 뒤에 0일 경우 앞에 1만 올 수 있음
     *   - 뒤에 9일 경우 앞에 8만 올 수 있음
     *
     * - 접근
     *   - n자리수 구하려면 n-1자리수에서 맨 앞글자가 무엇인지 봐야한다.
     *   - dp배열에 n자리수일 때 맨앞 숫자가 각각 몇개인지 기록한다.
     *   - n+1 자리수에서는 n자리수일 때의 dp기록을 통해
     *     계단수를 몇개 만들 수 있는지 알 수 있다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            System.out.println(n == 1 ? 9 : 17);
        } else {
            int num = 1000000000;
            long[] dp = new long[10]; // 0 ~ 9
            String[] s = {"01", "10", "12", "21", "23", "32", "34", "43",
                    "45", "54", "56", "65", "67", "76", "78", "87", "89", "98"};

            for (int i = 0; i < s.length; i++) {
                // 맨앞 숫자의 dp칸 +1
                dp[Character.getNumericValue(s[i].charAt(0))]++;
            }
            // 자릿수 2일 때의 계단수 입력 완료

            for (int i = 3; i <= n; i++) { // 자릿수 3부터 n까지
                long[] arr = new long[10];
                for (int j = 0; j < 10; j++) {
                    arr[j] = dp[j]; // 임시 배열에 이전 계단수 저장
                    dp[j] = 0; // dp 초기화
                }

                for (int j = 0; j < 10; j++) {
                    if (arr[j] != 0) {
                        if (j == 0) { // 앞에 1밖에 못옴
                            dp[1] = (dp[1] + arr[j]) % num;
                        } else if (j == 1) { // 앞에 0, 2옴
                            dp[0] = (dp[0] + arr[j]) % num;
                            dp[2] = (dp[2] + arr[j]) % num;
                        } else if (j == 9) { // 앞에 8만 옴
                            dp[8] = (dp[8] + arr[j]) % num;
                        } else {
                            dp[j + 1] = (dp[j + 1] + arr[j]) % num;
                            dp[j - 1] = (dp[j - 1] + arr[j]) % num;
                        }
                    }
                }
            }
            long sum = 0;
            for (int i = 1; i < 10; i++) {
                sum = (sum + dp[i]) % num;
            }
            System.out.println(sum);
        }
    }
}
