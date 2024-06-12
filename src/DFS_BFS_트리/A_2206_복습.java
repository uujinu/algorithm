package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_2206_복습 {

    static int n, m;
    static String[] map;
    static int[][][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int sol() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0}); // x, y, 벽 부순횟수

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                return visited[n - 1][m - 1][now[2]] + 1;
            }

            int num = visited[now[0]][now[1]][now[2]];
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (nx == 0 && ny == 0) continue;
                    if (map[nx].charAt(ny) == '1' && now[2] == 1) continue;

                    if (map[nx].charAt(ny) == '0') {
                        if (visited[nx][ny][now[2]] == 0 || visited[nx][ny][now[2]] > num + 1) {
                            visited[nx][ny][now[2]] = num + 1;
                            q.add(new int[]{nx, ny, now[2]});
                        }
                    } else if (visited[nx][ny][1] == 0 || visited[nx][ny][1] > num + 1) {
                        visited[nx][ny][1] = num + 1;
                        q.add(new int[]{nx, ny, 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        System.out.println(sol());
    }
}
