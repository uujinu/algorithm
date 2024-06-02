package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_18312 {

    /**
     * 00:00:00 시:분:초 형식일 때 숫자 K가 하나라도 포함된 모든 시각 구하기
     * 3중 for문으로 초단위로 시간을 늘려가면서 K 유무 검사하는 완전탐색으로 풀이
     */

    static boolean sol(int x, int k) {
        if (x < 10) { // 숫자가 10보다 작은 경우
            return x == k || k == 0;
        } else { // 숫자가 10보다 큰 경우
            return x % 10 == k || x / 10 == k;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int res = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int z = 0; z < 60; z++) {
                    if (sol(i, k) || sol(j, k) || sol(z, k)) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
