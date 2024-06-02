package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_19532 {

    /**
     * 주어진 연립방정식을 만족하는 x, y를 구하는 문제
     * x, y가 각각 -999 ~ 999 범위의 정수이므로
     * 이중 for문으로 모든 경우를 살펴보는 완전탐색으로 풀이
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] n = new int[6];
        for (int i = 0; i < 6; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                // 방정식을 만족할 경우 출력
                if (n[0] * i + n[1] * j == n[2] && n[3] * i + n[4] * j == n[5]) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
