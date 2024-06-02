package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_22864 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        // 한 시간 일하면 피로도 +a, 일은 +b,
        // 한 시간 쉬면 피로도 -c
        // 피로도 m 넘지 않게 일

        int A = 0, B = 0; // 피로도, 일

        if (a <= m) { // 피로도 증가량이 m 이하인 경우만
            for (int i = 0; i < 24; i++) {
                if (A + a > m) { // 일할 경우 피로도 m초과 -> 쉰다.
                    A -= c; // 피로도 감소
                    if (A < 0) A = 0; // 피로도 0 미만이면 0으로
                } else { // 일한다.
                    B += b; // 일 증가
                    A += a; // 피로도 증가
                }
            }
        }
        System.out.println(B);
    }
}