package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_1600_복습 {

    /**
     * k번만 말처럼 움직일 수 있다.
     * 큐에는 현재 좌표, k번, 이동횟수
     * 만약 visited에 [x][y][k]가 현재까지 움직인 이동횟수보다 작다면 return
     */

    static int[][] map;
    static int [][][] visited;
    static int w, h, k, res = Integer.MAX_VALUE;
    static int[][] monkey = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}},
            horse = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static Queue<int[]> q = new ArrayDeque<>();

    static void bfs() {
        q.add(new int[]{0, 0, 0, 0}); // 좌표, 이동횟수, k 사용횟수

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == h - 1 && now[1] == w - 1) {
                res = Math.min(res, now[2]);
                continue;
            }

            for (int d = 0; d < 4; d++) { // 일반 이동방법
                int nx = now[0] + monkey[d][0], ny = now[1] + monkey[d][1];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (nx == 0 && ny == 0 || map[nx][ny] == 1) continue;
                    if (visited[nx][ny][now[3]] == 0 || visited[nx][ny][now[3]] > now[2] + 1) {
                        visited[nx][ny][now[3]] = now[2] + 1;
                        q.add(new int[]{nx, ny, now[2] + 1, now[3]});
                    }
                }
            }

            if (now[3] < k) { // 말 이동방법으로 움직일 수 있음
                for (int d = 0; d < 8; d++) {
                    int nx = now[0] + horse[d][0], ny = now[1] + horse[d][1];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (nx == 0 && ny == 0 || map[nx][ny] == 1) continue;
                        if (visited[nx][ny][now[3] + 1] == 0 || visited[nx][ny][now[3] + 1] > now[2] + 1) {
                            visited[nx][ny][now[3] + 1] = now[2] + 1;
                            q.add(new int[]{nx, ny, now[2] + 1, now[3] + 1});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new int[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bfs();
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}
