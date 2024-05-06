package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_2960 {

    /**
     * 에라토스테네스의 체
     * 1. 2부터 N까지 모든 정수를 적는다.
     * 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
     * 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
     * 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
     * --------------------------------------------------------
     * N보다 작거나 같은 모든 소수를 찾는 과정에서
     * K번째 지우는 수 구하기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] b = new boolean[n + 1]; // 아직 지우지 않은 수는 false
        b[1] = true;
        int num = 0; // 몇 번째 지우는 수인지 기록
        int res = 0;

        for (int i = 2; i <= n; i++) {
            if (b[i]) continue; // 소수가 아닌 경우 pass

            // 아직 지우지 않은 수 중 가장 작은 수를 지우고, 그의 배수를 지워준다.
            for (int j = i; j <= n; j += i) {
                if (b[j]) continue;
                b[j] = true;
                num++;
                if (num == k) { // k번째 지우는 수인 경우
                    res = j;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
