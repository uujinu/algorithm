package DFS_BFS_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_14502 {

    static List<int[]> emptyArea = new ArrayList<>();
    static int n, m, virusArea, safeArea, wallArea, tmpSafeArea, res = Integer.MIN_VALUE;
    static int[][] map, tmpMap;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void copyMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
    }

    static void wall(int depth, int idx) {
        if (depth == 3) {
            // 바이러스 퍼뜨리기
            virusSpread();
            return;
        }

        for (int i = idx; i < emptyArea.size(); i++) { // 모든 빈 칸
            int[] now = emptyArea.get(i);
            map[now[0]][now[1]] = 1;
            wall(depth + 1, i + 1);
            map[now[0]][now[1]] = 0;
        }
    }

    static void virusSpread() {
        copyMap();
        tmpSafeArea = safeArea - 3; // 벽 3개 세울 것이므로 -3
        visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpMap[i][j] == 2 && !visited[i][j]) { // 바이러스 발견
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = now[0] + dir[d][0], ny = now[1] + dir[d][1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (tmpMap[nx][ny] == 0) { // 주변에 빈 칸이 있다면 퍼뜨림
                                    --tmpSafeArea; // 안전영역 감소
                                    visited[nx][ny] = true;
                                    tmpMap[nx][ny] = 2;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        res = Math.max(res, tmpSafeArea); // 안전영역 최대크기 갱신
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        tmpMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) ++virusArea; // 바이러스 개수
                else if (map[i][j] == 1) ++wallArea; // 벽 개수
                else emptyArea.add(new int[]{i, j}); // 빈 칸
            }
        }
        safeArea = n * m - virusArea - wallArea; // 안전영역 넓이

        if (safeArea <= 3) { // 안전영역이 3 이하일 경우 벽 3개 세우면 움직일 수 없음
            System.out.println(0);
        } else {
            // 벽 세우기
            wall(0, 0);
            // 결과 출력
            System.out.println(res);
        }
    }
}


/* // 빠른 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, max = 0, totalArea, wallArea, virusArea;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static List<Node> empty = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        wallArea = 0;
        totalArea = n * m;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) empty.add(new Node(i, j));
                if (map[i][j] == 1) wallArea++;
            }
        }

        wall(0, 0);
        System.out.println(max);
    }

    private static void wall(int startIdx, int count) {
        if (count == 3) {
            max = Math.max(max, totalArea - (wallArea + 3 + countVirusArea()));
            return;
        }
        for (int i = startIdx; i < empty.size(); i++) {
            Node cur = empty.get(i);
            map[cur.x][cur.y] = 1;
            wall(i + 1, count + 1);
            map[cur.x][cur.y] = 0;
        }
    }

    private static int countVirusArea() {
        virusArea = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    DFS(i, j);
                }
            }
        }
        return virusArea;
    }

    private static void DFS(int x, int y) {
        virusArea++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
            if (map[nx][ny] != 1) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

}
 */