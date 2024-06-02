package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A_18511 {

    /**
     * 재귀를 이용하여 각 자리에 모든 숫자를 넣어보는 완전탐색을 통해 풀이
     */

    static int[] num;
    static int res = 0;
    static StringBuilder sb;
    static int n, k;

    static void sol() {
        if (sb.length() > 0) {
            int tmp = Integer.parseInt(sb.toString());

            // 값이 n보다 크면 탐색 종료
            if (tmp > n) return;

            // 최대값 갱신
            res = Math.max(res, tmp);
        }

        for (int i = k - 1; i >= 0; i--) {
            sb.append(num[i]);
            sol();
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        // n 이하의 자연수 중 집합 k 원소로만 구성된 가장 큰 수
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        sol();

        System.out.println(res);
    }
}