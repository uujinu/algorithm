package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_1743_복습 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = Integer.MIN_VALUE;
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1, c = Integer.parseInt(st.nextToken()) - 1;
            arr[r][c] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !v[i][j]) {
                    int size = 1;
                    v[i][j] = true;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (arr[nx][ny] == 1 && !v[nx][ny]) {
                                    ++size;
                                    v[nx][ny] = true;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    res = Math.max(res, size);
                }
            }
        }
        System.out.println(res);
    }
}
