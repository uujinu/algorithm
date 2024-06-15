package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_7562 {

    /**
     * 최단 경로 구하기: bfs 사용
     */

    static class Loc {
        int x, y;
        int len;

        public Loc(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static int l;
    static int[] loc, goal;
    static Queue<Loc> q;

    // 8가지 방향
    static int[][] dir = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};


    static int bfs() {
        q = new ArrayDeque<>();
        boolean[][] v = new boolean[l][l];

        // 현재 위치
        v[loc[0]][loc[1]] = true;
        q.add(new Loc(loc[0], loc[1], 0));

        while (!q.isEmpty()) { // goal까지의 최단 경로 찾기
            Loc now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dir[i][0], ny = now.y + dir[i][1];
                if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                    if (nx == goal[0] && ny == goal[1]) { // 목표 도착 시 리턴
                        return now.len + 1;
                    }

                    if (!v[nx][ny]) {
                        v[nx][ny] = true;
                        q.add(new Loc(nx, ny, now.len + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            l = Integer.parseInt(br.readLine()); // 한 변의 길이
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 현재 위치
            loc = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            // 이동할 위치
            goal = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            if (loc[0] == goal[0] && loc[1] == goal[1]) {
                sb.append(0).append('\n');
            } else sb.append(bfs()).append('\n');
        }
        System.out.println(sb.toString());
    }
}
