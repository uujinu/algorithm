package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class A_1743 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] v = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayDeque<int[]> trash = new ArrayDeque<>();
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1, c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
            trash.add(new int[]{r, c});
        }

        int res = Integer.MIN_VALUE;

        while (!trash.isEmpty()) {
            int[] t = trash.poll();
            if (v[t[0]][t[1]]) continue;

            v[t[0]][t[1]] = true;
            q.add(new int[]{t[0], t[1]});
            int size = 1;
            while(!q.isEmpty()) {
                int[] now = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 1 && !v[nx][ny]) {
                            v[nx][ny] = true;
                            size++;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            res = Math.max(res, size);
        }
        System.out.println(res);
    }
}
