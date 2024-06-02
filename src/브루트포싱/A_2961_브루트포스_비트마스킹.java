package 브루트포싱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_2961_브루트포스_비트마스킹 {

    // 브루트포스 풀이
    /*
    static int min = Integer.MAX_VALUE;
    static int b = 0;
    static int s = 1;
    static int[][] ing;
    static boolean[] v;
    static int n, m;

    static void dfs(int depth, int idx) {
        if (depth == m) {
            min = Math.min(min, Math.abs(b - s));
        }

        for (int i = idx; i < n; i++) {
            s *= ing[i][0];
            b += ing[i][1];
            dfs(depth + 1, i + 1);
            s /= ing[i][0];
            b -= ing[i][1];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ing = new int[n][2];
        v = new boolean[n];
        // s 신맛 = 사용한 재료의 신맛의 곱, b 쓴맛 = 합
        // 신맛 쓴맛 차이 작게 하려고 한다. 재료 하나 이상 사용.
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ing[i][0] = Integer.parseInt(st.nextToken()); // 신맛
            ing[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        // 초기화
        min = Math.abs(ing[0][0] - ing[0][1]);
        for (int i = 1; i <= n; i++) {
            m = i; // 재료 선택할 개수
            dfs(0, 0);
        }

        System.out.println(min);
    }

     */

    // 2. 비트마스킹 풀이
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] t = new int[n][2];
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i][0] = Integer.parseInt(st.nextToken());
            t[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1 << 5의 경우 10000
        // i < (1 << n)이므로 10000에서 1을 뺀 0001부터 1111까지 순회
        for (int i = 1; i < (1 << n); i++) {
            long s = 1, b = 0;
            for (int j = 0; j < n; j++) { // 각 n자리 선택여부 체크
                // 만약 i가 0101일 경우 j가 각각 0, 2일 때 조건 만족
                if ((i & (1 << j)) == 1 << j) {
                    s *= t[j][0];
                    b += t[j][1];
                }
            }
            res = Math.min(res, Math.abs(s - b)); // 차이 최소값 구하기
        }
        System.out.println(res);
    }
}