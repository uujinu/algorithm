package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()); // x일 동안 가장 많이 들어온 방문자 수, 그 기간이 몇 번 반복되었는지 구하기
        int[] a = new int[n + 1];
        int max = 0; // 방문자 수
        int day = 0; // 기간

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + Integer.parseInt(st.nextToken()); // 누적합 구함
        }

        for (int i = x; i <= n; i++) { // x일 동안의 누적합을 비교하여 최대값 구하기
            int prev = i - x;
            int tmp = a[i] - a[prev];
            if (tmp == max) {
                day++;
            } else if (tmp > max) {
                day = 1;
                max = tmp;
            }
        }
        if (max != 0) {
            sb.append(max).append('\n').append(day);
        }
        System.out.println(max == 0 ? "SAD" : sb.toString());
    }
}
