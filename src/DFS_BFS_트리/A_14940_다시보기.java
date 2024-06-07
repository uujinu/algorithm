package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class A_14940_다시보기 {

    /**
     * 각 위치로 가는 최단 거리를 구하는 문제이므로
     * bfs로 풀이
     */

    /**
     * 7576은 "하루 단위로 끊어서 봐야 한다.". 즉, 한 칸 움직였을 때마다 기록한다면
     * 이 문제는 "거리마다 끊어서 봐야한다."
     * 주어진 칸에서 얼마나 떨어졌는지 기록하므로 주어진 칸에서 동일하게 떨어진
     * 칸에는 같은 숫자들이 들어가야 한다.
     */

    static int n, m;
    static Loc goal;
    static int[][] map;
    static boolean[][] visited;
    static ArrayDeque<Loc> q;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        q.add(goal);
        visited[goal.x][goal.y] = true;
        int len = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Loc now = q.poll();
                map[now.x][now.y] = len;
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dir[i][0], ny = now.y + dir[i][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (!visited[nx][ny] && map[nx][ny] != -1) {
                            visited[nx][ny] = true;
                            q.add(new Loc(nx, ny));
                        }
                    }
                }
            }
            len++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new ArrayDeque<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) goal = new Loc(i, j);
                else if (num == 0) map[i][j] = -1;
                else map[i][j] = -2; // 갈 수 있는 땅 -2로 표시
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) sb.append("0 ");
                else if (map[i][j] == -2) sb.append("-1 ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
