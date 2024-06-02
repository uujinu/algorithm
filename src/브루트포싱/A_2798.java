package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A_2798 {

    /**
     * N개의 카드 중 3장을 골라 카드의 합이 최대한 M에 가까운 경우 구하기
     * 완전탐색으로 구현
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int sum = 0; // 세 수의 합
        int max = 0; // 최대값

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // 세 수의 합
                    sum = num[i] + num[j] + num[k];

                    // 합이 m보다 크면 넘어감
                    if (sum > m) break;
                    else max = Math.max(max, sum); // 최대값 갱신
                }
            }
        }
        System.out.println(max);
    }
}
