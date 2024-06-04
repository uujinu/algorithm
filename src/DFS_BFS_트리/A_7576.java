package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_7576 {

    static int[][] map;
    static Queue<int[]> q;
    static int num, res, n, m;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void bfs() {
        while(num > 0) {
            int size = q.size();
            boolean check = false;
            while(size-- > 0) {
                int[] now = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 0) {// 익지 않은 토마토 발견
                            check = true;
                            --num;
                            map[nx][ny] = 1;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            if (!check) return;
            else ++res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // num: 안 익은 토마토 개수
                if (map[i][j] == 0) ++num;

                // 익은 토마토 좌표 큐에 넣기
                else if (map[i][j] == 1) q.add(new int[]{i, j});
            }
        }

        if (num == 0) { // 안 익은 토마토가 없다면 0 출력
            System.out.println(0);
        } else { // 토마토가 다 익지 못하면 -1 출력
            bfs();
            System.out.println(num != 0 ? -1 : res);
        }
    }
}
