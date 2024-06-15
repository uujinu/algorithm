package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class A_16954 {

    /**
     * 1초마다
     * - 모든 벽이 아래 행으로 한 칸 내려감(가장 아래칸은 벽이 사라짐)
     * - 캐릭터는 상하좌우, 대각선으로 한 칸 움직이거나 이동하지 않음
     *   - 이동 시 빈칸으로만 이동
     * - 캐릭터 먼저 이동하고 벽 이동함
     * - 벽이 캐릭터 있는 칸으로 이동 시 더 이상 움직일 수 없음
     *
     * 왼쪽 아래 칸에서 오른쪽 위 칸으로 갈 수 있는지 구하기
     */

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        char[][] map = new char[8][8];
        Queue<Loc> wall = new ArrayDeque<>();
        Queue<Loc> q = new ArrayDeque<>();

        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '#')
                    wall.add(new Loc(i, j));
            }
        }
        q.add(new Loc(7, 0));

        // 캐릭터 이동
        while(!q.isEmpty()) {

            if (wall.size() == 0) {
                System.out.println(1);
                return;
            }

            int size = q.size();
            while(size-- > 0) {
                Loc now = q.poll();

                for (int i = 0; i < dir.length; i++) {
                    int nx = now.x + dir[i][0], ny = now.y + dir[i][1];
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        if (nx == 0 && ny == 7) {
                            System.out.println(1);
                            return;
                        }

                        if (map[nx][ny] == '.') { // 벽 아닌 곳 있음
                            q.add(new Loc(nx, ny));
                        }
                    }
                }
            }
            if (q.size() == 0) {
                System.out.println(0);
                return;
            }

            // 벽 움직임
            int wSize = wall.size();
            while (wSize-- > 0) {
                Loc now = wall.poll();
                map[now.x][now.y] = '.'; // 초기화
                if (now.x + 1 == 8) {
                    continue;
                }
                wall.add(new Loc(now.x + 1, now.y));
            }

            wSize = wall.size();
            while(wSize-- > 0) {
                Loc now = wall.poll();
                map[now.x][now.y] = '#';
                wall.add(now);
            }

            // 살아남은 캐릭터가 있는가
            size = q.size();
            while(size-- > 0) {
                Loc now = q.poll();
                if (map[now.x][now.y] == '.') { // 살아남음
                    q.add(now);
                }
            }
        }
        System.out.println(0);
    }
}
