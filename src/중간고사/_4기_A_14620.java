package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4기_A_14620 {

    static int n;
    static int[][] loc;
    static int[][] map;
    static boolean[][] v, visited;
    static int min = Integer.MAX_VALUE;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void sol(int sum) {
        visited = new boolean[n][n];

        for (int i = 0; i < 3; i++) {
            visited[loc[i][0]][loc[i][1]] = true;
            v[loc[i][0]][loc[i][1]] = true;
        }

        int val = sum;
        boolean flag = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = loc[i][0] + dir[i][0], ny = loc[i][1] + dir[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) { // 범위 내
                    if (visited[nx][ny]) {
                        flag = false;
                        break;
                    }
                    else {
                        visited[nx][ny] = true;
                        val += map[nx][ny];
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) min = Math.min(min, val);
    }

    static void select(int depth, int r, int c, int sum) {
        if (depth == 3) {
            sol(sum);
            return;
        }

        int tmp = c;
        for (int i = r; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while(tmp -- > 0) j++;
                if (!v[i][j]) {
                    loc[depth][0] = i;
                    loc[depth][1] = j;
                    v[i][j] = true;
                    select(depth + 1, r, c, sum + map[i][j]);
                    v[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new boolean[n][n];
        loc = new int[3][2];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        select(0, 0, 0, 0);
        System.out.println(min);
    }
}
