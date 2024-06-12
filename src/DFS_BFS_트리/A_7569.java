package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class A_7569 {

    /**
     * 토마토가 모두 익는 최소 일수 구하기
     */

    static int[][] map;
    static int[][] dir;
    static boolean[][] v;
    static int m, n, h, r;
    static ArrayDeque<int[]> q; // 익은 토마토 저장

    static int sol() {
        int res = 0; // 날짜

        while (!q.isEmpty()) {
            int size = q.size(); // 현재 익은 토마토로만 while문 돌림

            while (size-- > 0) {
                // 가로(m)*층 + 위치
                int[] now = q.poll();
                int f = now[1] / m; // 현재 층

                for (int i = 0; i < 6; i++) {
                    int nx = now[0] + dir[i][0], ny = now[1] + dir[i][1];

                    if (i == 2 || i == 3) { // 왼쪽 오른쪽 움직일 때 층수 넘기면 안됨
                        if (ny < m * f || ny >= m * (f + 1)) continue;
                    }

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m * h) { // 범위 내
                        if (!v[nx][ny] && map[nx][ny] == 0) { // 안익은 토마토
                            v[nx][ny] = true;
                            map[nx][ny] = 1;
                            r--;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            res++; // 하루 지남
            if (r == 0) return res; // 모든 토마토가 익은 경우 종료
        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();

        // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
        dir = new int[][]{{0, m}, {0, -m}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // m:가로, n:세로, h:높이
        // 가장 아래 상자부터 위 상자까지의 토마토 정보
        // 0 ~ m - 1: 1층, m ~ 2 * m - 1: 2층
        map = new int[n][m * h];
        v = new boolean[n][m * h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[j][m * i + k] = Integer.parseInt(st.nextToken());

                    // 1 익은 토마토, 0 안익은 토마토
                    if (map[j][m * i + k] == 1) { // 익은 토마토 큐에 저장
                        q.add(new int[]{j, m * i + k});
                        v[j][m * i + k] = true;
                    } else if (map[j][m * i + k] == 0) r++; // 안 익은 토마토 개수 저장
                }
            }
        }

        int res;

        // 모든 토마토 익은 상태면 0, 모두 익지 못하는 상태면 -1
        if (r == 0) res = 0;
        else if (q.size() == 0 && r != 0) res = -1;
        else res = sol();

        System.out.println(r != 0 ? -1 : res);
    }
}
