package 수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제설명 : 주어진 범위 내에서 소수 판별하기
 * 핵심개념 : 소수 찾기, 에라토스테네스의 체 활용
 */

public class A_1929_소수판별_에라토스테네스의체 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        // boolean 배열로 소수 여부를 표시한다.
        // 소수가 아닌 것을 true로 설정한다. (소수이면 false)
        boolean[] eratos = new boolean[N + 1];
        eratos[1] = true;

        // 2부터 시작하고, N의 제곱근까지 계산한다. => 시간복잡도 O(√N)
        for (int k = 2; k <= Math.sqrt(N); k++) {
            if (eratos[k]) continue; // 소수가 아니라고 표시된 경우 건너 뛴다.

            // 지워지지 않은 수 중 가장 작은 수를 소수로 하고, 그의 배수를 모두 true로 지워준다.
            for (int j = k + k; j <= N; j += k) {
                eratos[j] = true;
            }
        }

        // false인 값의 인덱스를 모두 출력해준다.
        for (int b = M; b <= N; b++) {
            if (!eratos[b]) sb.append(b).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}