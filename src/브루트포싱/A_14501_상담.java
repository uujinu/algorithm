package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_14501_상담 {

    static int[][] arr;
    static int max;
    static int n;

    static void dfs(int idx, int sum) {
        if (sum > max) max = sum;
        if (idx >= n) return;

        if (idx + arr[idx][0] - 1 < n) { // 날짜 범위 내
            dfs(idx + arr[idx][0], sum + arr[idx][1]); // 오늘 상담 해보기
        }
        dfs(idx + 1, sum); // 오늘 상담 패스
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(max);
    }
}
