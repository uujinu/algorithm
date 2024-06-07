package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class A_2178 {

    /**
     * 최단거리를 구하는 문제
     * 현재 노드와 가까운 곳부터 탐색하는 bfs로 구현
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int[][] map = new int[n][m];
        int[][] num = new int[n][m]; // 이동 칸 수 기록
        boolean[][] visited = new boolean[n][m];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) map[i][j] = Integer.parseInt(s[j]);
        }

        dq.add(new int[]{0, 0}); // (0, 0)에서 출발
        num[0][0] = 1; // 이동 칸 수 1부터 시작
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int number = num[now[0]][now[1]]; // 현재까지 이동 칸 수

            for (int i = 0; i < 4; i++) { // 4방향 순회
                int nx = now[0] + dir[i][0], ny = now[1] + dir[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) { // 이동 가능한 칸
                        visited[nx][ny] = true;
                        dq.add(new int[]{nx, ny});
                        num[nx][ny] = number + 1;
                    }
                }
            }
        }
        System.out.println(num[n - 1][m - 1]);
    }
}
