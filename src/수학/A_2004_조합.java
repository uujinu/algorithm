package 수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제설명 : nCm의 끝자리 0의 개수를 출력하라.
 * 핵심개념 : 조합 개념, 끝자리에 0이 나오기 위한 조건
 */

public class A_2004_조합 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 끝자리에 0이 n개 있다는 의미는 2와 5가 n개씩 짝지어 존재한다는 것이다. (2×5 = 10 이므로)
        // 10의 개수는 2의 개수와 5의 개수 중 더 작은 값이다.
        int res  = Math.min(
                getCounts(n, 2) - (getCounts(m, 2) + getCounts(n - m, 2)),
                getCounts(n, 5) - (getCounts(m, 5) + getCounts(n - m, 5))
        );
        System.out.println(res);
    }

    public static int getCounts(int n, int k) {
        int res = 0;
        while (n >= k) {
            res += n / k;
            n /= k;
        }
        return res;
    }
}
